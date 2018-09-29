package topic5.cartService;
import java.util.Collection;

public interface CartService {
	// Returns the list of items in the cart
	public Collection<Item> getItems();

	// Adds an item to the cart, returns true if successful
	public Item addItem(Item item);

	// Empties the cart, returns true if successful
	public void emptyCart();

	// Returns the total price of the cart
	public int price();

	// Removes the given Item from the cart, returns true if successful, returns
	// false if item is not present.
	public boolean remove(int id);
}