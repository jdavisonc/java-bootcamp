package abstractFactory;

public class FactoryProducer {
	
	public static DatabaseFactory getFactory(DataBaseType type) {

		switch (type) {
		case MYSQL: return new MySqlFactory();
		case ORACLE: return new OracleFactory();
		default: return new MySqlFactory();
		}
		
	}

}
