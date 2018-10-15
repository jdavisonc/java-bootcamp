package cartservice;

import java.sql.SQLException;
import java.sql.Statement;

import DBManager.DBConnect;
import DBManager.Database;



public class prodToCart {
	/**
	 * Returns true if the product is successfully added to the cart
	 * takes a new object product with the user´s id and product´s id as integers
	 * and other object database with MySQL user, password and database name as String
	 *
	 *@param prod 	    New object product that needs id of the user and id of the product as String parameters
	 *@param database 	New object database that needs user, password and database name as String parameters
	 *@return			true if the product is successfully added to cart, otherwise returns false
	 */
	public static Boolean addProd(product prod, Database database) {
		String query = "";
		DBConnect db = new DBConnect();
		try {
			Statement sentence = db.conn(database).createStatement();
			query = "INSERT INTO cart(Prodcart, Usercart) VALUES (" + prod.getIdprod() + ", " + prod.getIduser() +");";
			sentence.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		  }
	}	
}
