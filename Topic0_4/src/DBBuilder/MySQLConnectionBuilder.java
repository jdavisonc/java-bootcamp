package DBBuilder;

public class MySQLConnectionBuilder implements DBConnectionBuilder {
	
	private DBConnection connection;
	
	public MySQLConnectionBuilder() {
			connection = new DBConnection();
	}
	
	@Override 
	public void buildUser() {
		connection.setUser("root");
	}
	
	@Override 
	public void buildPwd() {
		connection.setPwd("masterkey");
	}
	
	@Override 
	public void buildUrl() {
		connection.setUrl("jdbc:mysql://localhost:3306/personas?useSSL=false&serverTimezone=UTC");
	}
	
	public DBConnection getDBConnection() {
		return connection;
	}
}