package abstract_factory;

public class AccountsFactory extends DatabaseFactory {

	@Override
	MysqlDatabase getMysql() {
		return new AccountsMsql();
	}

	@Override
	MongoDBDatabase getMongoDB() {
		return new AccountsMdb();
	}
}