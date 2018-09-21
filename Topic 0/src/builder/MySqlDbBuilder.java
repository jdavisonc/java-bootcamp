package builder;

public class MySqlDbBuilder implements DatabaseBuilder {
	
	private Database db;
	
	public MySqlDbBuilder () {
		db = new Database();
	}
	
	@Override
	public void buildUrl() {
		db.setDbUrl("localhost://mysql");
	}

	@Override
	public void buildUser() {
		db.setUser("admin");
		
	}

	@Override
	public Database getDatabase() {
		return db;
	}

}
