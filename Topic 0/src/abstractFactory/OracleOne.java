package abstractFactory;

public class OracleOne implements Database {
	@Override
	public String connect() {
		return "Connected to OracleOne";
	}

}
