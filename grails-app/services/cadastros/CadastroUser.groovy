package cadastros
import repositorios.IRep
import repositorios.RepUser
import entidades.User

class CadastroUser {
	public IRep<User> repUser;
	public CadastroUser(){
		repUser = new RepUser();
	}
	public void salvarUser(User user){
		if(repUser.findId(user.getNumero()) == null){
			repUser.save(User);
		}
	}
	public void removerUser(long id){
		if(repUser.findId(id) != null){
			repUser.delete(id);
		}
	}
	public User recuperarUser(long id){
		return repUser.findId(id);
	}
	public List<User> recuperarUser(){
		return repUser.all();
	}
}
