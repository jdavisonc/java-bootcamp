package builder;

public class DatabaseDirector {
	
	private DatabaseBuilder dbBuilder = null;
	
	public DatabaseDirector(DatabaseBuilder dbBuilder) {
		this.dbBuilder = dbBuilder;
	}
	
	public void buildDb(String user) {
		dbBuilder.buildUser(user);
		dbBuilder.buildUrl();
	}
	
	public Database getDatabase() {
		return dbBuilder.getDatabase();
	}

}
