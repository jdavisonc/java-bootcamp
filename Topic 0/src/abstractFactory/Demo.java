package abstractFactory;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataBaseType oracleType = DataBaseType.ORACLE;
		DatabaseFactory oracleFactory = FactoryProducer.getFactory(oracleType);
		Database oracle1 = oracleFactory.getDatabase(1);
		
		oracle1.connect();
		
		Database oracle2 = oracleFactory.getDatabase(2);
		oracle2.connect();
		DataBaseType mysqlType = DataBaseType.MYSQL;
		DatabaseFactory mysqlFactory = FactoryProducer.getFactory(mysqlType);
		Database mysql2 = mysqlFactory.getDatabase(1);
		
		String connection = mysql2.connect();
		
		System.out.println(connection);
		
		Database mysql1 = mysqlFactory.getDatabase(1);
		
		mysql1.connect();
		
		
	}

}
