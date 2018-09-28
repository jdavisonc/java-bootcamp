package abstract_factory;

public class ConnectionMaker {
	public static DatabaseFactory establishConnection(String connect) {
		DatabaseFactory db;
		switch (connect) {
		case "clients":
			db = new ClientsFactory();
			break;
		case "accounts":
			db = new AccountsFactory();
			break;
		default:
			db = null;
			break;
		}
		return db;
	}
}
