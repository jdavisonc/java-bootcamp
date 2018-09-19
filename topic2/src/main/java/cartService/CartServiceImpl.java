package cartService;
import java.util.LinkedList;

public class CartServiceImpl implements CartService{
	
	private LinkedList<Item> items = new LinkedList<Item>();
	
	public LinkedList<Item> getItems() {
		return this.items;
	}

	public boolean addItem(Item item) {
		return this.items.add(item);
	}
	
	public void emptyCart() {
		this.items.clear();
	}

	public double price() {
		double result = 0;
		for (Item item : this.items) {
			result += item.getPrice();
		}
		return result;
	}

	public boolean remove(Item item) {
		if (this.items.contains(item)) {
			this.items.remove(item);
		}
		return false;
	}

}
