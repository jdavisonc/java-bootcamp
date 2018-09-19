package practiceTopic0.Practice4;

public class ConcreteBuilder2 implements BuilderInterface{
	
	private Connection connection;
	
	public ConcreteBuilder2() {
			connection = new Connection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("user2");
	}
	
	@Override
	public void buildPassword() {
		connection.setPassword("pass2");
	}

	@Override
	public void buildDB() {
		connection.setDb("db2");
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}
	
	
}
