package DBBuilder;

public class Demo {

	public static void main (String[] args) {
		
		DBConnectionBuilder dbconnBuilder = new MySQLConnectionBuilder();
		ConnectionDirector  connDirector  = new ConnectionDirector(dbconnBuilder);
		connDirector.constructConnection();
		DBConnection dbconn = connDirector.getDBConnection();
		dbconn.Connecting();
	}
}