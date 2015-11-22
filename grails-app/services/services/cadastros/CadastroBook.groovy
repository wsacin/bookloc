package services.cadastros

import bookloc.Book
import services.repositorios.IRep
import services.repositorios.RepBook

class CadastroBook {

	public IRep<Book> repBook;
	
	public CadastroBook(){
		repBook = new RepBook();
	}

	public Book salvarBook(Book book){
		if (book == null)
            throw new NoSuchElementException()

        if (book.hasErrors())
            throw new IllegalArgumentException()

		repBook.save(book);
	}

    public Book criarBook(params){
        repBook.create(params);
    }

	public Boolean removerBook(Book book){
		if (book == null)
			throw new NoSuchElementException()
		repBook.delete(book);
	}

	public Book recuperarBook(Book book){
		return repBook.find(book);
	}
	
	public List<Book> recuperarBooks(){
		return repBook.all();
	}
	
}
