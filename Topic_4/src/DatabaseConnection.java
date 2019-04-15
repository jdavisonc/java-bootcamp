import java.sql.*;

public class DatabaseConnection {
	public static void main(String args[]) {

		Connection dtbCon = null;

		try {
			dtbCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?autoReconnect=true&useSSL=false",
					"java", "123");
			Statement stat = dtbCon.createStatement();
			ResultSet myRes = stat
					.executeQuery("SELECT CONCAT(t.last_name_teacher, \", \", t.first_name_teacher) as Teacher, "
							+ "CONCAT(c.Schedule_time, \" \", c.course_name) as Schedule\r\n"
							+ "FROM Course as c, teacher as t\r\n" + "WHERE t.idTeachers = 3\r\n"
							+ "GROUP BY teacher\r\n" + "ORDER BY c.Schedule_time ASC;");

			while (myRes.next()) {

				System.out.print(myRes.getString("Teacher"));
				System.out.println(" " + myRes.getString("Schedule"));
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}