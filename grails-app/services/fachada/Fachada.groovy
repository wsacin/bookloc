package fachada

import controladores.ControladorBook
import controladores.ControladorUser
//import controladores.ControladorDOC
import entidades.Book
import entidades.User
//import entidades.DOC

class Fachada {

    static constraints = {
    }
	private static Fachada instance;
	//private ControladorDOC controladorDOC
	private ControladorBook controladorBook
	private ControladorUser controladorUser
	private Fachada(){
		 controladorBook = new ControladorBook()
		 controladorUser = new ControladorUser()
	}
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	public User getUser(long idUser){
		return controladorUser.getUser(idUser);
	}
	public void criarUser(User c){
		controladorUser.criarUser(c);
	}
	public void criarBook(Book c){
		controladorBook.criarBook(c);
	}
	public List<User> users(){
		return controladorUser.users();
	}
	public List<Book> books(){
		return controladorBook.books();
	}
}
