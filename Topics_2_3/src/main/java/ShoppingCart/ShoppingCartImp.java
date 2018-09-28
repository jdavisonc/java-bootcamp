package ShoppingCart;

import java.util.ArrayList;

/**
 * Contains the logic of the Shopping Cart service.
 * 
 * @author Victor Munareto
 *
 */
public class ShoppingCartImp implements ShoppingCart {
	Database databaseConnection;
	ArrayList<Product> productsInCart;

	/**
	 * Constructor for the class. It simulates establishing a connection to the
	 * database and initializes the list of products inside the cart.
	 */
	protected ShoppingCartImp() {
		databaseConnection = new Database();
		productsInCart = new ArrayList<Product>();
	}

	/**
	 * Puts a given quantity of products inside of the cart.
	 * 
	 * @param product
	 * @param quantity
	 * @return Item(s) added to the cart.
	 */
	@Override
	public String putItems(Product product, int quantity) {
		productsInCart.add(product);
		product.setDesiredQuantity(quantity);

		return "Item(s) added to cart.";
	}

	/**
	 * Deletes a given product from the cart.
	 * 
	 * @param product
	 * @param quantity
	 * @return Item(s) deleted.
	 */
	@Override
	public String deleteItems(Product product, int quantity) {
		if (product.getDesiredQuantity() >= quantity) {
			product.setDesiredQuantity(product.getDesiredQuantity() - quantity);
			if (product.getDesiredQuantity() == 0) {
				productsInCart.remove(product);
			}
		}
		return "Item(s) deleted.";
	}

	/**
	 * Allows the user to modify the quantity of desired products.
	 * 
	 * @param product
	 * @param desiredQuantity
	 * @return Item(s) modified
	 */
	@Override
	public String updateItems(Product product, int desiredQuantity) {
		if (!(product.getAvailableQuantity() < desiredQuantity)) {
			int index = productsInCart.indexOf(product);
			productsInCart.get(index).setDesiredQuantity(desiredQuantity);
		}
		return "Item(s) modified.";
	}

	/**
	 * Calculates the total price of the products inside of the cart. To do so, it
	 * sums the price of each product and multiplies it by the product's desired
	 * quantity.
	 * 
	 * @return int price
	 */
	@Override
	public int calculateTotalPrice() {
		int price = 0;
		for (Product product : productsInCart) {

			price += product.getPrice() * product.getDesiredQuantity();

		}
		return price;
	}

	/**
	 * 
	 * @return The cart's current product list.
	 */
	public ArrayList<Product> getProductList() {
		return this.productsInCart;
	}

	/**
	 * Calls the method calculateTotalPrice()
	 *
	 * @return Total price of current product list.
	 */
	public int getTotalPrice() {

		return calculateTotalPrice();
	}
}
