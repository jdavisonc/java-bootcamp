package abstractFactory;

public class OracleTwo implements Oracle{

	@Override
	public String getConnection() {
		return "Connected to OracleTwo";
	}

}
