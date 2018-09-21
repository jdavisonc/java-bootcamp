package singleton;

public class DBSingleton {

	private static DBSingleton db = null;

	private DBSingleton() {
		// Create the database connection here
		// String url = "localhost";
		// String dbName = "MyDatabase";
		// String driver = "com.mysql.jbdc.Driver";
		// String user = "user";
		// String pass = "pass";

	}

	public static DBSingleton getInstance() {
		if (db == null) {
			db = new DBSingleton();
		}
		return db;
	}

}
