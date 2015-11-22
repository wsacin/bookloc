package services.controladores

import bookloc.Book
import services.cadastros.CadastroBook

class ControladorBook {

	CadastroBook cadastroBook
	
	public ControladorBook() {
		cadastroBook = new CadastroBook();
	}
	
	public Book buscarBook(Book book){
		cadastroBook.recuperarBook(book)
	}

	public Book criarBook(params){
		cadastroBook.criarBook(params)
	}

	public Book salvarBook(Book book){
		cadastroBook.salvarBook(book)
	}

    public void removerBook(Book book){
        cadastroBook.removerBook(book)
    }

	public List<Book> books(){
		cadastroBook.recuperarBooks()
	}
}
