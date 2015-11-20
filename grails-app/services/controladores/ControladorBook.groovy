package controladores

import cadastros.CadastroBook
import entidades.Book
import entidades.User

class ControladorBook {

	CadastroBook cadastroBook
	
	public ControladorBook()
	{
		cadastroBook = new CadastroBook();
	}
	
	public Book getBook(long idBook){
		
		cadastroBook.recuperarBook(idBook)
	}

	public void criarBook(Book c){
		cadastroBook.salvarBook(c)
		
	}
	
	public List<Book> books(){
		cadastroBook.recuperarBooks()
	}
}
