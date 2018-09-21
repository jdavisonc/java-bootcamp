package topic4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MySQLAccess {

	Connection conn = null;
	Statement statement = null;
	ResultSet resultSet = null;
	ResultSetMetaData resultSetMeta = null;

	public void connect() {
		String query = "SELECT CONCAT(t.lastName, \", \", t.firstName ) as Teacher, CONCAT(c.ScheduleTime, \": \", c.name) as Schedule\r\n" + 
				"FROM teachers as t, Courses as c\r\n" + 
				"WHERE t.ID = 2;";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/high_school?" + "user=test&password=test");
			statement = conn.createStatement();
			statement.executeQuery(query);
			resultSet = statement.getResultSet();
			resultSetMeta = (ResultSetMetaData) resultSet.getMetaData();
			System.out.println("Printing query:\n" + query);

			int columnsNum = resultSetMeta.getColumnCount();
			System.out.println(columnsNum);

			while (resultSet.next()) {
				for (int i = 1; i <= columnsNum; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue + " " + resultSetMeta.getColumnName(i));
				}
				System.out.println("");
			}

			// Do something with the Connection
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException sqlEx) {
				} // ignore

				resultSet = null;
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqlEx) {
				} // ignore

				statement = null;
			}
		}
	}
}