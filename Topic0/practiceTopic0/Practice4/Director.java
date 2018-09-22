package practiceTopic0.Practice4;

public class Director {
	private BuilderInterface connectionBuilder = null;

	public Director(BuilderInterface connectionBuilder) {
		this.connectionBuilder = connectionBuilder;
	}

	public void constructConnection(String user, String password, String database) {
		connectionBuilder.withUser(user);
		connectionBuilder.withPassword(password);
		connectionBuilder.withDB(database);

	}

	public Connection getConnection() {
		return connectionBuilder.buildConnection();
	}
}
