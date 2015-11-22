package bookloc

import services.fachada.Fachada

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    Fachada fachada = Fachada.getInstance()

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]
    }

    def show(User user) {
        respond fachada.buscarUser(user)
    }

    def create() {
        respond fachada.criarUser(params)
    }

    @Transactional
    def save(User user) {
        try{
            fachada.salvarUser(user)
        }
        catch(IllegalArgumentException e1){
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'create'
            return

        }
        catch(NoSuchElementException e2){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(User user) {
        respond user
    }

    @Transactional
    def update(User user) {
        try{
            fachada.salvarUser(user)
        }
        catch(IllegalArgumentException e1){
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }
        catch(NoSuchElementException e2){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Transactional
    def delete(User user) {
        try {
            fachada.removerUser(user)
        }
        catch(NoSuchElementException e){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
