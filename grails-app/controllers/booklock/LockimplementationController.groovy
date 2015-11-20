package booklock
import fachada.Fachada
class LockimplementationController {

    Fachada fachada = Fachada.getInstance()
	
	def dados()
	{
		def books = fachada.books();
		def users = fachada.users();
		return [books:books,users:users]
	}
	
    def index() {
		dados()
	}
	def mostrarDOC(){
		dados()
	}
	def realizarDOC(){
		
		//fachada.fazerDOC(new DOC(params))
		redirect(action: "index")
		
	}
	def criarUser(){}
	def criarBook(){}
	def books(){}
	def users(){}
}
