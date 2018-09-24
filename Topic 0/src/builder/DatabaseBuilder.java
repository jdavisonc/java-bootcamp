package builder;

public interface DatabaseBuilder {
	
	public void buildUrl();
	public void buildUser(String user);
	public Database getDatabase();

}
