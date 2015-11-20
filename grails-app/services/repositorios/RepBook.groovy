package repositorios

import entidades.Book


public class RepBook implements IRep<Book>{
	

	public RepBook(){
	
	}
	
	public List<Book> all(){
		return Book.all
	}
	
	public Book findId(long id){
		return Book.find {isbn == id }
	}
	
	public void save(Book book){
		if(book.save(flush: true))
		{
			//lançar exceção
		}
	}
	
	public void delete(long id){
		Book.find {isbn == id }.delete();
	}


}
