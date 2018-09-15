package abstractFactory;

public class OracleOne implements Oracle {

	@Override
	public String getConnection() {
		return "Connected to OracleOne";
	}

}
