package ShoppingCart;

import java.util.ArrayList;

/**
 * Mock database class. Contains the list of products and users.
 * 
 * @author Victor Munareto
 *
 */
public class Database {

	ArrayList<Product> productList;
	ArrayList<User> userDatabase;

	/**
	 * This constructor initializes the database's lists and fills the product list
	 * with three kind of products.
	 */
	public Database() {
		userDatabase = new ArrayList<User>();
		productList = new ArrayList<Product>();
		productList.add(new Product("Android phone", "Technology", 100, 600));
		productList.add(new Product("Levono Laptop", "Technology", 60, 1000));
		productList.add(new Product("T-shirt", "Clothes", 100, 20));
	}
}
