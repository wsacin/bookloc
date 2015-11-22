package services.repositorios

import bookloc.Book

public class RepBook implements IRep<Book>{
	
	public List<Book> all(){
		Book.all
	}

    public Book find(Book book) {
        return book
    }

	public Book create(params){
        new Book(params)
	}

    public Book save(Book book){
        book.save flush:true
    }

	public void delete(Book book){
        book.delete flush:true
	}
}
