package builder;

public class AccountsDatabase implements ConnectionBuilder {

	private MysqlDatabase database;

	public AccountsDatabase() {
		database = new MysqlDatabase("Accounts database", "www.database.com/Accounts", "123");
	}

	@Override
	public MysqlDatabase getDatabase() {

		return database;
	}

}