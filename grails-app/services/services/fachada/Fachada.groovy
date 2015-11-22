package services.fachada

import bookloc.Book
import bookloc.User
import services.controladores.ControladorBook
import services.controladores.ControladorUser

class Fachada {

    static constraints = {
    }
	private static Fachada instance;
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

    // book
    public Book buscarBook(Book book){
        return controladorBook.buscarBook(book);
    }
	public Book criarBook(params){
		controladorBook.criarBook(params);
	}
    public Book salvarBook(Book book){
        controladorBook.salvarBook(book);
    }
    public void removerBook(Book book){
        controladorBook.removerBook(book);
    }
	public List<Book> books(){
		return controladorBook.books();
	}

    // user
    public User buscarUser(Book user){
        return controladorUser.buscarUser(user);
    }
    public User criarUser(params){
        controladorUser.criarUser(params);
    }
    public User salvarUser(Book user){
        controladorUser.salvarUser(user);
    }
    public void removerUser(User user){
        controladorUser.removerUser(user);
    }
    public List<User> users(){
        return controladorUser.users();
    }
}
