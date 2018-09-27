package abstract_factory;

public class AccountsMsql implements DatabaseInterface {

	@Override
	public String connectTo() {

		return "Connection to MYSQL accounts database established.";
	}

}
