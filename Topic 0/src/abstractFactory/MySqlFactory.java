package abstractFactory;

public class MySqlFactory extends DatabaseFactory{

	@Override
	MySql getMySqlDb(String mySql) {
		
		if (mySql.equalsIgnoreCase("TWO")) {
			return new MySqlTwo();
		}
		return new MySqlOne();
	}

	@Override
	Oracle getOracleDb(String oracle) {
		return null;
	}

}
