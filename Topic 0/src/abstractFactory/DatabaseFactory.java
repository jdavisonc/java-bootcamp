package abstractFactory;

public abstract class DatabaseFactory {
	abstract MySql getMySqlDb(String mySql);
	abstract Oracle getOracleDb(String oracle);
}
