package abstractFactory;

public class FactoryProducer {
	public static DatabaseFactory getFactory(String type) {
		if (type.equalsIgnoreCase("MYSQL")) {
			return new MySqlFactory();
		}
		if (type.equalsIgnoreCase("ORACLE")) {
			return new OracleFactory();
		}
		//Defaults to MySql
		return new MySqlFactory();
		
	}

}
