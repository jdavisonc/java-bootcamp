package abstractFactory;

public class MySqlOne implements MySql {

	@Override
	public String getConnection() {
		return "Connected to MySql One";
	}

}
