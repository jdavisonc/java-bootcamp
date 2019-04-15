package builder;

public class DatabaseDirector {
	private ConnectionBuilder database = null;

	public DatabaseDirector(ConnectionBuilder database) {
		this.database = database;
	}

	public MysqlDatabase getDatabase() {
		return database.getDatabase();
	}
}
