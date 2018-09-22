package practiceTopic0.Practice4;

public class ConcreteBuilder2 implements BuilderInterface {

	private Connection connection;

	public ConcreteBuilder2() {
		connection = new Connection();
	}

	@Override
	public void withUser(String user) {
		connection.setUser(user);
	}

	@Override
	public void withPassword(String pass) {
		connection.setPassword(pass);
	}

	@Override
	public void withDB(String db) {
		connection.setDb(db);
	}

	@Override
	public Connection buildConnection() {
		return connection;
	}
}
