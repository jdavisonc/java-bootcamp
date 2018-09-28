package singleton;

public class Demo {

	public static void main(String args[]) {

		System.out.println("Establishing connection to database...");

		SingletonDatabase connection = SingletonDatabase.getConnection();

		connection.connectionStatus();

		multipleConnections(connection);

	}

	/*
	 * The method multipleConnections() is used to test the Singleton pattern. It
	 * receives an object (already created) of the singleton class, tries to
	 * create a new object of the same class and verifies if the new object
	 * points to the previous one.
	 */
	
	private static void multipleConnections(SingletonDatabase createdConnection) {
		System.out.println("Establishing new connection...");
		SingletonDatabase newConnection = SingletonDatabase.getConnection();
		if (newConnection == createdConnection) {
			System.out.println("You can't have multiple connections active. Singleton works!");
		} else {
			System.out.println("New connection established. Singleton isn't working!");
		}
	}
}