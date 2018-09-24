package builder;

public class MySqlDbBuilder implements DatabaseBuilder {
	
	private Database db;
	
	public MySqlDbBuilder () {
		db = new Database();
	}
	
	@Override
	public void buildUrl() {
		db.setDbUrl("localhost://mysql:" + db.getUser());
	}

	@Override
	public void buildUser(String user) {
		db.setUser(user);
		
	}

	@Override
	public Database getDatabase() {
		return db;
	}

}
