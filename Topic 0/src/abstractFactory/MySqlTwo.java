package abstractFactory;

public class MySqlTwo implements MySql{

	@Override
	public String getConnection() {
		return "Connected to MySql Two";
	}

}
