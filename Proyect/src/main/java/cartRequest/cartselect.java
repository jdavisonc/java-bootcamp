package cartRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBManager.DBConnect;
import DBManager.Database;



public class cartselect {
		static String prodName;
		static float prodPrice;
		static String query = "";
		/**
		 * Returns an ArrayList that in each position
		 * has the name of the product as nameProd
		 * and the price of the product as priceProd
		 * it needs the id from the current user as integer
		 * and a new object database with user, password 
		 * and database name as String
		 * 
		 * @param  iduser  	 The id of the user owner of the cart
		 * @param  database	 New object with user, password and database name as String
		 * @return 			 ArrayList with name of the product as String and price of the product as integer   
		 */
		public static ArrayList<cartitems> cartbuilder(int iduser, Database database) {
		cartuser cart = new cartuser(iduser);
		DBConnect db = new DBConnect();
		ArrayList<cartitems> cartdata = new ArrayList<cartitems>();
		try {
			Statement sentence = db.conn(database).createStatement();
			query = "SELECT NameProd, PriceProd FROM products JOIN cart ON products.IdProd = cart.ProdCart WHERE cart.UserCart = " + cart.getIduser() + ";";
			ResultSet cartSelected = sentence.executeQuery(query);
			//add data to arraylist
			while (cartSelected.next()) {
				prodName  = cartSelected.getNString("NameProd");
				prodPrice = cartSelected.getFloat("PriceProd");
				cartitems item = new cartitems(prodName, prodPrice);
				cartdata.add(item);
			}
		} catch (SQLException e) {
		  }
		return cartdata;
	}
}
