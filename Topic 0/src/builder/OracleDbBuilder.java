package builder;

public class OracleDbBuilder implements DatabaseBuilder {
	
	private Database db;
	
	public OracleDbBuilder () {
		db = new Database();
	}
	
	@Override
	public void buildUrl() {
		db.setDbUrl("localhost://oracle");
	}

	@Override
	public void buildUser() {
		db.setUser("system");
		
	}

	@Override
	public Database getDatabase() {
		return db;
	}

}
