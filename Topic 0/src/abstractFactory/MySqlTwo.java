package abstractFactory;

public class MySqlTwo implements Database {
	@Override
	public String connect() {
		return "Connected to MySql Two";
	}

}
