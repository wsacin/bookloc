package services.repositorios

public interface IRep<C> {
	
	public List<C> all()
	public C find(C c)
	public C create(params)
	public C save(C c)
	public void delete(C c)
}