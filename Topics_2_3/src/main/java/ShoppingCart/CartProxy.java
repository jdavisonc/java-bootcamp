package ShoppingCart;

/**
 * Proxy class for Shopping Cart implementation, this class can be used to make
 * the service local and initialize it without having to re-write the logic
 * code.
 * 
 * @author Victor Munareto
 *
 */
public class CartProxy implements ShoppingCart {

	ShoppingCart cart;

	/**
	 * Constructor for the Shopping Cart proxy, receives an instance of type
	 * ShoppingCart.
	 * 
	 * @param requestCartService
	 */

	protected CartProxy(ShoppingCart requestCartService) {
		cart = requestCartService;
	}

	@Override
	public String putItems(Product product, int quantity) {

		return cart.putItems(product, quantity);
	}

	@Override
	public String deleteItems(Product product, int quantity) {

		return cart.deleteItems(product, quantity);
	}

	@Override
	public String updateItems(Product product, int desiredQuantity) {

		return cart.updateItems(product, desiredQuantity);
	}

	@Override
	public int calculateTotalPrice() {

		return cart.calculateTotalPrice();
	}
}
