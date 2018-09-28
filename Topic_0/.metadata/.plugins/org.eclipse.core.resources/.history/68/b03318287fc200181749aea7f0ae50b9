package abstract_factory;

public class Demo {
	public static void main(String[] args) {

		/*
		 
		 */
		DatabaseFactory db = ConnectionMaker.establishConnection("accounts");
		MysqlDatabase accounts = db.getMysql();
		System.out.println(accounts.connectTo());

		DatabaseFactory db2 = ConnectionMaker.establishConnection("clients");
		MongoDBDatabase clients = db2.getMongoDB();
		System.out.println(clients.connectTo());

	}
}
