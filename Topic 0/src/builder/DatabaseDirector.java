package builder;

public class DatabaseDirector {
	
	private DatabaseBuilder dbBuilder = null;
	
	public DatabaseDirector(DatabaseBuilder dbBuilder) {
		this.dbBuilder = dbBuilder;
	}
	
	public void buildDb() {
		dbBuilder.buildUrl();
		dbBuilder.buildUser();
	}
	
	public Database getDatabase() {
		return dbBuilder.getDatabase();
	}

}
