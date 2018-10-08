package abstractFactory;

public class MySqlOne implements Database {

	@Override
	public String connect() {
		return "Connected to MySql One";
	}

}
