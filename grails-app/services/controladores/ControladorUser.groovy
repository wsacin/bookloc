package controladores

import cadastros.CadastroUser
import entidades.User

class ControladorUser {

	CadastroUser cadastroUser
	
	public ControladorUser()
	{
		cadastroUser = new CadastroUser()
	}
	
	public User getUser(long idUser){
		cadastroUser.recuperarUser(idUser)
	}

	public void criarUser(User c){
		cadastroUser.salvarUser(null)
	}
	
	public List<User> users(){
		cadastroUser.recuperarUsers()
	}
}
