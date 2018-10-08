package builder;

public class OracleDbBuilder implements DatabaseBuilder {
	
	private Database db;
	
	public OracleDbBuilder () {
		db = new Database();
	}
	
	@Override
	public void buildUrl() {
		db.setDbUrl("localhost://oracle:"+ db.getUser());
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
