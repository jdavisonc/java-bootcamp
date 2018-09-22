package abstractFactory;

public class OracleTwo implements Database{
	@Override
	public String connect() {
		return "Connected to OracleTwo";
	}

}
