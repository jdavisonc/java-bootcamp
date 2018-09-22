package practiceTopic0.Practice4;

public interface BuilderInterface {
	public void withUser(String user);

	public void withPassword(String pass);

	public void withDB(String db);

	public Connection buildConnection();

}
