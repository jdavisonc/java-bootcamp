package abstract_factory;

public class Demo {
	public static void main(String[] args) {

		/*
		 * We call the database factory to establish a connection to the Accounts
		 * database, then we connect to the mysql database type.
		 */

		DatabaseFactory db = ConnectionMaker.establishConnection("accounts");
		DatabaseInterface accounts = db.getConnection("mysql");
		System.out.println(accounts.connectTo());

		/*
		 * We call the database factory to establish a connection to the Clients
		 * database, then we connect to the mongodb database type.
		 */

		DatabaseFactory db2 = ConnectionMaker.establishConnection("clients");
		DatabaseInterface clients = db2.getConnection("mongodb");
		System.out.println(clients.connectTo());

	}
}
