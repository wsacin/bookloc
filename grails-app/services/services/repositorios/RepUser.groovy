package services.repositorios

import bookloc.User;

public class RepUser implements IRep<User>{

    public List<User> all(){
		User.all
	}

    public findByName(String name){
        return User.find{username == name}
    }

    public User find(User user) {
        return user
    }

	public User create(params){
        new User(params)
	}

    public User save(User user){
        user.save flush:true
    }

	public void delete(User user){
        user.delete flush:true
	}
}