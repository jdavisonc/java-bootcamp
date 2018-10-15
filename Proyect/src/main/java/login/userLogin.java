package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBManager.DBConnect;
import DBManager.Database;

public class userLogin {
	/**
	 * Method to check if the user an password provided are correct
	 * 
	 * @param  userData New object dataLogin with nickName and password as String parameters
	 * @param  database New object Database with SQL user, password and database name as Strings
	 * @return "Correct" if the user and password are correct 
	 * 			"Wrong" if the user or password is wrong/doesn't exists, or "Error" if is an SQL exception
	 */
	public String checkLogin(dataLogin userData, Database database) {
		String query = "";
		DBConnect db = new DBConnect();
		try {
			Statement sentence = db.conn(database).createStatement();
			query = "Select UserName, Password from user where UserName = '" + userData.nickName + "';";
			ResultSet rs = sentence.executeQuery(query);
			if (rs.first()){
				if ((rs.getString("Password").compareToIgnoreCase(userData.Password))==0){
					return "Correct";
				}
			}
			return "Wrong";
		} catch (SQLException e) {
			return "Error";
		  }
		
	}
}
