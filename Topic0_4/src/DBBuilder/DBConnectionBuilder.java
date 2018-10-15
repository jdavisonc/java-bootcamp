package DBBuilder;

public interface DBConnectionBuilder {
	
	public void buildUser();
	
	public void buildPwd();
	
	public void buildUrl();
	
	public DBConnection getDBConnection();
}