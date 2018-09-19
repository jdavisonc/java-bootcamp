package practiceTopic0.Practice4;

public class ConcreteBuilder1 implements BuilderInterface{
	
	private Connection connection;
	
	public ConcreteBuilder1() {
			connection = new Connection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("user1");
	}
	
	@Override
	public void buildPassword() {
		connection.setPassword("pass1");
	}

	@Override
	public void buildDB() {
		connection.setDb("db1");
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}
	
	
}
