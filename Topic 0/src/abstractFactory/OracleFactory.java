package abstractFactory;
public class OracleFactory extends DatabaseFactory{

	@Override
	MySql getMySqlDb(String mySql) {
		
		return null;
	}

	@Override
	Oracle getOracleDb(String oracle) {
		if (oracle.equalsIgnoreCase("TWO")) {
			return new OracleTwo();
		}
		return new OracleOne();
	}

}