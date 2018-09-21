package cartService;

import java.util.LinkedList;

public interface CartService {
	// Returns the list of items in the cart
	LinkedList<Item> getItems();

	// Adds an item to the cart, returns true if successful
	boolean addItem(Item item);

	// Empties the cart, returns true if successful
	void emptyCart();

	// Returns the total price of the cart
	double price();

	// Removes the given Item from the cart, returns true if successful, returns
	// false if item is not present.
	boolean remove(Item item);
}