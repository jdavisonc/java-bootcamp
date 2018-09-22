package topic5.cartService;
import java.util.LinkedList;

public interface SimpleCartService {
	// Returns the list of items in the cart
	public LinkedList<String> getItems();

	// Adds an item to the cart, returns true if successful
	public boolean addItem(String item);

	// Empties the cart, returns true if successful
	public void emptyCart();

	// Returns the total price of the cart
	public double price();

	// Removes the given Item from the cart, returns true if successful, returns
	// false if item is not present.
	public boolean remove(String item);
}