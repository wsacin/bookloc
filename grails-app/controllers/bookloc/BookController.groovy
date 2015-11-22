package bookloc

import services.fachada.Fachada

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BookController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    Fachada fachada = Fachada.getInstance()

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Book.list(params), model:[bookCount: Book.count()]
    }

    def show(Book book) {
        respond fachada.buscarBook(book)
    }

    def create() {
        respond fachada.criarBook(params)
    }

    @Transactional
    def save(Book book) {
        try{
            fachada.salvarBook(book)
        }
        catch(IllegalArgumentException e1){
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'create'
            return

        }
        catch(NoSuchElementException e2){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }

    def edit(Book book) {
        respond book
    }

    @Transactional
    def update(Book book) {
        try{
            fachada.salvarBook(book)
        }
        catch(IllegalArgumentException e1){
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'edit'
            return
        }
        catch(NoSuchElementException e2){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }

    @Transactional
    def delete(Book book) {
        try {
            fachada.removerBook(book)
        }
        catch(NoSuchElementException e){
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
