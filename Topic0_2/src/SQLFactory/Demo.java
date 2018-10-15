package SQLFactory;

import java.sql.Connection;

public class Demo {
	public static void main (String[] args) {
		AbstractFactory abstractfactory = new AbstractFactory();
		SQLType SQLT = new MySQLType();
		Connection connecting = SQLT.getConnection("MySQL");
		
	}
}
