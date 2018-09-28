package abstract_factory;

public class AccountsMdb implements DatabaseInterface {

	@Override
	public String connectTo() {

		return "Connection to MongoDB accounts database established.";
	}

}
