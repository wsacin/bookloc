package repositorios;

import java.util.List;

public interface IRep<C> {
	
	
	public List<C> all();
	
	public C findId(long id);
	
	public void save(C c);
	
	
	public void delete(long id);
}