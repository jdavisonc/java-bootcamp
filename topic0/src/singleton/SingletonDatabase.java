package singleton;

public class SingletonDatabase {
	private static SingletonDatabase connection = null;

	private SingletonDatabase() {

	}

	public static SingletonDatabase getConnection() {
		if (connection == null) {
			connection = new SingletonDatabase();
		}
		return connection;
	}

	public void connectionStatus() {
		if (connection != null) {
			System.out.println("You are connected to Singleton Database.");
		} else {
			System.out.println("You are not connected to Singleton Database");
		}
	}
}