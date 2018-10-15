package BuyCart;

import java.sql.SQLException;
import java.sql.Statement;

import DBManager.DBConnect;
import DBManager.Database;

public class deleteCart {
	/**
	 * delete a cart associates to the user's id provided
	 * 
	 * @param userid id from the owner of the cart
	 * @param database New object with SQL user, password and database name as Strings
	 * @return true if successfully deleted, false if doesn't
	 */
	public static boolean delete(int userid,Database database) {
		String query = "";
		DBConnect db = new DBConnect();
		try {
			Statement sentence = db.conn(database).createStatement();
			query = "DELETE FROM cart WHERE UserCart = " + userid;
			sentence.executeQuery(query);
			return true;
		} catch (SQLException e) {
			  e.printStackTrace();
			  return false;
	      }		
	}
}
