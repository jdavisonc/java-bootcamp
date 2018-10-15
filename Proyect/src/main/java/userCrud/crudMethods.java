package userCrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBManager.DBConnect;
import DBManager.Database;
import userCrud.usersCRUD;


public class crudMethods {
	 static String query = "";	
	 
	/**
	 * Receives a userData object with username(required), email, phone, address, nickname(required) and password(required)
	 * and returns String according to:
	 *  User already exists    : return "Already Exists"
	 * 	User successfully added: return "Succeed"
	 *  Could not add the user : return "Error"
	 * 
	 * @param userdata	New object with username(required), email, phone, address, nickname(required) and password(required)
	 * @param database 	New object database that needs String user String password and String database name as parameters
	 * @throws SQLException
	 */
	public static String userADD(userData userdata, Database database) throws SQLException {
		boolean nickExistence = false;
		DBConnect db = new DBConnect();
		Statement sentence = db.conn(database).createStatement();
		try {
			query = "SELECT * FROM user WHERE userName = " + userdata.getNickName();
			ResultSet selectedUser = sentence.executeQuery(query); 
			if (selectedUser.next()) {
				nickExistence = true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		  }
		if (!nickExistence) {
			query= "INSERT INTO user(NameUser, Email, Phone, Address, UserName, Password) VALUES ('" + userdata.getuserName() +
			"', '" + userdata.getEmail() + "', '" + userdata.getphone() + "', '" + userdata.getaddress() + "', '" + 
			userdata.getNickName() + "', '" + userdata.getPassword() + "'; ";
			if (sentence.executeUpdate(query) > 0) {
				return ("Succeed");
			} else {
					return ("Error");
			  }
		} else {
				return ("Already exists");
			   }
		  }		
	
	/**
	 * Search the user given the user's id and a database object
	 *  
	 * @param id		user's id
	 * @param database  New object Database with user, password and database name as String
	 * @return			An Arraylist including userName, Email, phone, address, nickName and password as strings
	 * @throws SQLException
	 */
	public static ArrayList<usersCRUD> userView(int id, Database database) throws SQLException {
		ArrayList<usersCRUD> userData = new ArrayList<usersCRUD>();
		String userName = null;
		String email = null;
		String phone = null;
		String address = null;
		String nickName = null;
		String password = null;
		DBConnect db = new DBConnect();
		Statement sentence = null;
		try {
			sentence = db.conn(database).createStatement();
			query = "SELECT * FROM users WHERE idusers = " + id;
			ResultSet selectedUser = sentence.executeQuery(query); 
			if (selectedUser.first()) {
				usersCRUD uc = new usersCRUD(userName, email, phone, address, nickName, password);
				uc.userName = selectedUser.getString("firstName");
				uc.email = selectedUser.getString("email");
				uc.phone = selectedUser.getString("phone");
				uc.address = selectedUser.getString("address");
				uc.nickName = selectedUser.getString("nickName");
				uc.password = selectedUser.getString("password");
				userData.add(uc);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		  }
		sentence.close();
		return userData;
	}
	
	/**
	 * Save modifications of the user's profile
	 * 
	 * @param id	     User's id as Integer
	 * @param userdata   New object userData with the information to update. userName, email, phone, address, nickname and password as Strings
	 * @param  database	 New object with user, password and database name as String
	 * @return			 "Successfully Modified" is update goes well, "Error" if could not update or "non-existent" if the user doesn't exists
	 * @throws SQLException
	 */
	
	public static String userUPDATE(int id, userData userdata, Database database) throws SQLException {
		boolean nickExistence = false;
		DBConnect db = new DBConnect();
		Statement sentence = db.conn(database).createStatement();
		try {
			query = "SELECT * FROM users WHERE UserName = " + userdata.getNickName();
			ResultSet selectedUser = sentence.executeQuery(query); 
			if (selectedUser.next()) {
				nickExistence = true;
			}
		} catch (SQLException e) {
			
				e.printStackTrace();
		  }
		if (nickExistence) {
			query= "UPDATE users SET UserName = '" + userdata.getuserName()  + "', email = '" + userdata.getEmail() +
					"', phone = '" + userdata.getphone() +"', address = '" + userdata.getaddress() + "', nickName = '" + 
					userdata.getNickName() + "', password = '" + userdata.getPassword() + "';";
			if (sentence.executeUpdate(query) > 0) {
				sentence.close();
				return "Succesfully modified";
			} else {
					sentence.close();
					return "Error";
			  }
		} else {
				sentence.close();
				return ("non-existent");
		  }	
	}	
	
	/**
	 * 
	 * @param id		User's id to delete as integer
	 * @param database  New object Database with user, password and database name as String parameters
	 * @return			"Deleted" if successfully deleted or "Could not delete" if it couldn't be deleted
	 * @throws SQLException
	 */
	public static String userDELETE(int id, Database database) throws SQLException {
		DBConnect db = new DBConnect();
		Statement sentence = db.conn(database).createStatement();
				query= "DELETE * from users WHERE IdUser = " + id;
			if (sentence.executeUpdate(query) > 0) {
				sentence.close();
				return ("Deleted");
			} else {
				sentence.close();
					return ("Could not delete");
			  }		
	}
	
		
}
