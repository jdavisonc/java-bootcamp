package abstractFactory;
public class OracleFactory implements DatabaseFactory{

	@Override
	public Database getDatabase(int id) {
		switch (id) {
		case 1: return new OracleOne();
		case 2: return new OracleTwo();
		default: return new OracleOne();
		}
	}

}