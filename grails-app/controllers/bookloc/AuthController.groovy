package bookloc

import grails.converters.JSON
import grails.transaction.Transactional
import services.auth.JsonAuth
import services.fachada.Fachada

@Transactional(readOnly = true)
class AuthController {

    Fachada fachada = new Fachada()

    def authuser() {
        JSON json = request.JSON
        render fachada.autenticarUser(json) as JSON
    }
}
