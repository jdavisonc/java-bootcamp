package practiceTopic0.Practice4;

public class Director {
	private BuilderInterface connectionBuilder = null;

	public Director(BuilderInterface connectionBuilder) {
		this.connectionBuilder = connectionBuilder;
	}

	public void constructConnection() {
		connectionBuilder.buildUser();
		connectionBuilder.buildPassword();
		connectionBuilder.buildDB();

	}

	public Connection getConnection() {
		return connectionBuilder.getConnection();
	}
}
