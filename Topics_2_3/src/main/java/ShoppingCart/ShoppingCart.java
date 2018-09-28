package ShoppingCart;

/**
 * Interface for shopping carts.
 * 
 * @author Victor Munareto
 *
 */
public interface ShoppingCart {

	String putItems(Product product, int quantity);

	String deleteItems(Product product, int quantity);

	String updateItems(Product product, int desiredQuantity);

	int calculateTotalPrice();

}