package abstract_factory;

public class ClientsMdb implements DatabaseInterface {

	@Override
	public String connectTo() {

		return "Connection to MongoDB clients database established.";
	}

}
