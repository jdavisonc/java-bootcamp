package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	/**
	 * Connection to MySQL database
	 * Return Connection variable conn or print 
	 * the SQL Exception if is there one
	 * 
	 * @param db	Database object with user, password and database name as strings
	 */
	public Connection conn(Database db) {
		String User = db.getUser();
		String Pwd = db.getPwd();
		String database = db.getdb();
		String Url = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false&serverTimezone=UTC";
		Connection con = null;
		try {
			con = DriverManager.getConnection(Url,User,Pwd);
		} catch (SQLException se) {
		    System.err.println(se);
	 	  }
		return con;
	}

}
