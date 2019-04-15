package builder;

public class ClientsDatabase implements ConnectionBuilder {

	private MysqlDatabase database;

	public ClientsDatabase() {
		database = new MysqlDatabase("Clients database", "www.database.com/Clients", "321");
	}

	@Override
	public MysqlDatabase getDatabase() {

		return database;
	}

}
