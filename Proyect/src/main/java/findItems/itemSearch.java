package findItems;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBManager.DBConnect;
import DBManager.Database;

public class itemSearch {
	
	/**
	 * Search the products by category and name
	 * 
	 * @param  category Id of the category as Integer, every category's id is 0
	 * @param  nameProd Part of the name of the product as String, every products' tag is nameProd=""
	 * @param  database New object Database with SQL user, password and database name as String parameters
	 * @return ArrayList with the desired products' Category and ProductName as dataItems or null if nothing found
	 */
	public static ArrayList<dataItems> Searching(int category, String nameProd, Database database){
		String query= "";
		String nameprod;
		float  priceprod;
		String descprod;
		DBConnect db = new DBConnect();
		try {
			Statement sentence = db.conn(database).createStatement();
			ArrayList<dataItems> productlist = new ArrayList<dataItems>();
			query = "SELECT * FROM products";
			boolean catbool  = category==0;
			boolean namebool = nameProd=="";
			if (!(catbool) && !(namebool)){
				query = query + " WHERE CategoryProd = " + category + " AND NameProd LIKE '%" + nameProd + "%';";
			} else if (!(namebool)) {
					query = query + " WHERE NameProd LIKE '%" + nameProd + "%';";
			  } else if (!(catbool)) {
				  	query = query + " WHERE CategoryProd = " + category;
			  	}
			ResultSet rs = sentence.executeQuery(query);
			while (rs.next()){
				nameprod = rs.getString("NameProd");
				priceprod = rs.getFloat("PriceProd");
				descprod = rs.getString("DescriptionProd");
				dataItems data = new dataItems(nameprod, priceprod, descprod);
				productlist.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }		
		return null;
		
	}
}
