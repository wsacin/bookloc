package services.controladores

import bookloc.User
import services.cadastros.CadastroUser

class ControladorUser {

	CadastroUser cadastroUser
	
	public ControladorUser() {
		cadastroUser = new CadastroUser()
	}
	
	public User buscarUser(User user){
		cadastroUser.recuperarUser(user)
	}

	public User criarUser(params){
		cadastroUser.criarUser(params)
	}

	public User salvarUser(User user){
		cadastroUser.salvarUser(user)
	}

	public void removerUser(User user){
		cadastroUser.removerUser(user)
	}

	public List<User> users(){
		cadastroUser.recuperarUsers()
	}
}
