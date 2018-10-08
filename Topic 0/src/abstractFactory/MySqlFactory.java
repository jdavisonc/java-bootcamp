package abstractFactory;

public class MySqlFactory implements DatabaseFactory{

	@Override
	public Database getDatabase(int id) {
		switch (id) {
		case 1: return new MySqlOne();
		case 2: return new MySqlTwo();
		default: return new MySqlOne();
		}
	}

}
