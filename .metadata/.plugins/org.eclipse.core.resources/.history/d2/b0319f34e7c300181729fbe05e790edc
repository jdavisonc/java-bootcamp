package topic5.cartService;
import java.util.LinkedList;

public interface CartService {
	// Returns the list of items in the cart
	public LinkedList<Item> getItems();

	// Adds an item to the cart, returns true if successful
	public boolean addItem(Item item);

	// Empties the cart, returns true if successful
	public void emptyCart();

	// Returns the total price of the cart
	public int price();

	// Removes the given Item from the cart, returns true if successful, returns
	// false if item is not present.
	public boolean remove(int id);
}