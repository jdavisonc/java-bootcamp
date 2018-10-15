package BuyCart;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;

import DBManager.DBConnect;
import DBManager.Database;
import cartRequest.cartitems;
import cartRequest.cartselect;

public class buyitems {
	/**
	 * Add to database, the order number of the purchase, user, product name, product price, total price and date of the purchase
	 * @param userid	id of the buyer
	 * @param totalprice total price of the cart
	 * @param database new object with SQL user, password and database name
	 * @return "Succeed" if it went all right, "Error" if didn't
	 */
	public String completesail(int userid, float totalprice, Database database) {
		DBConnect db = new DBConnect();
		String query = "";
		Date d = new Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		int i = 0;
		ArrayList<cartitems> items = new ArrayList<cartitems>();
		items.addAll(cartselect.cartbuilder(userid, database));
		try {
			Statement sentence = db.conn(database).createStatement();
			query="SELECT (PriceProd) FROM products ORDER BY PriceProd DESC LIMIT 0,1;";
			int ordernum = sentence.executeUpdate(query) + 1;
			while (i<items.size()) {
				query = "INSERT INTO purchasehistory(ordernum, userPurchase, productname, productprice, totalprice, datepurchase) "
						+ "VALUES (" + ordernum + ", " + userid + ", '" + items.get(i).getProdName() + 
						"', '" + items.get(i).getProdPrice() + "', '" + totalprice + "', '" + date + "');";
						i+=i;
			}
			deleteCart.delete(userid, database);
			return "Succeed";
		} catch (SQLException e) {
			   e.printStackTrace();
			   return "Error";
	      }
	}
}
