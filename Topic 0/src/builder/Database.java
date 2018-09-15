package builder;

public class Database {
	private String user;
	private String dbUrl;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	
	public String toString() {
		return "Database "+dbUrl+ " connected with user " +user;
	}
	
}
