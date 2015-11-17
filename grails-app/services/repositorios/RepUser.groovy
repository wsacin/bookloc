package repositorios

import java.util.List;

import entidades.Book;
import entidades.User;

class RepUser implements IRep<User> {
	
	public List<User> all(){
		return User.all
	}
	
	public User findId(long id){
		return User.find {cpf == id }
	}
	
	public void save(User user){
		if(user.save(flush: true))
		{
			//lançar exceção
		}
	}
	
	public void delete(long id){
		User.find {cpf == id }.delete();
	}



}
