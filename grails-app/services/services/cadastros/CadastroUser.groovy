package services.cadastros

import bookloc.User
import services.repositorios.IRep
import services.repositorios.RepUser

class CadastroUser {

	public IRep<User> repUser;

	public CadastroUser(){
		repUser = new RepUser();
	}

    public User salvarUser(User user){
        if (user == null)
            throw new NoSuchElementException()

        if (user.hasErrors())
            throw new IllegalArgumentException()

        repUser.save(user);
    }

    public User criarUser(params){
        repUser.create(params);
    }

    public Boolean removerUser(User user){
        if (user == null)
            throw new NoSuchElementException()
        repUser.delete(user);
    }

    public User recuperarUser(User user){
        return repUser.find(user);
    }

    public List<User> recuperarUsers(){
        return repUser.all();
    }

}