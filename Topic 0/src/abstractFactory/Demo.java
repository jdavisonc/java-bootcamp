package abstractFactory;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseFactory oracleFactory = FactoryProducer.getFactory("Oracle");
		Oracle oracle1 = oracleFactory.getOracleDb("one");
		
		oracle1.getConnection();
		
		Oracle oracle2 = oracleFactory.getOracleDb("two");
		oracle2.getConnection();
		
		DatabaseFactory mysqlFactory = FactoryProducer.getFactory("MySQL");
		MySql mysql2 = mysqlFactory.getMySqlDb("two");
		
		String connection = mysql2.getConnection();
		
		System.out.println(connection);
		
		MySql mysql1 = mysqlFactory.getMySqlDb("one");
		
		mysql1.getConnection();
		
		
	}

}
