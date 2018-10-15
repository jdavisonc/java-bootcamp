package DBBuilder;

public class ConnectionDirector {
	private DBConnectionBuilder dbconnBuilder = null;
	
	public ConnectionDirector(DBConnectionBuilder dbconnBuilder) {
		this.dbconnBuilder = dbconnBuilder;
	}
	
	public void constructConnection() {
		dbconnBuilder.buildUser();
		dbconnBuilder.buildPwd();
		dbconnBuilder.buildUrl();
	}
	
	public DBConnection getDBConnection() {
		return dbconnBuilder.getDBConnection();
	}
}
