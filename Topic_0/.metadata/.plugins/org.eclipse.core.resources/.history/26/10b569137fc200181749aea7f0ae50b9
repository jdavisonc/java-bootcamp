package abstract_factory;

public class ClientsFactory extends DatabaseFactory {

	@Override
	MysqlDatabase getMysql() {
		return new ClientsMsql();

	}

	@Override
	MongoDBDatabase getMongoDB() {
		return new ClientsMdb();
	}
}