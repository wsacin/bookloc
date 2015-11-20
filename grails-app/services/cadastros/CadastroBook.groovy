package cadastros

import repositorios.IRep
import repositorios.RepBook
import entidades.Book

class CadastroBook {

	public IRep<Book> RepBook;
	
	public CadastroBook(){
		repBook = new RepBook();
	}
	
	public void salvarBook(Book book){
		if(repBook.findId(book.getIdentificador()) == null){
			repBook.save(book);
		}
	}

	
	public void removerBook(long id){
		if(repBook.findId(id) != null){
			repBook.delete(id);
		}
	}
	
	
	
	public Book recuperarBook(long id){
		return repBook.findId(id);
	}
	
	public List<Book> recuperarBooks(){
		return repBook.all();
	}
	
}
