package cartService;
import java.util.LinkedList;

public class CartServiceProxy implements CartService{
	
	CartService imp;
	
	protected CartServiceProxy(CartService imp) {
		this.imp = imp;
	}

	public LinkedList<Item> getItems() {
		return imp.getItems();
	}

	public boolean addItem(Item item) {
		return imp.addItem(item);
	}

	public void emptyCart() {
		imp.emptyCart();
	}

	public double price() {
		return imp.price();
	}

	public boolean remove(Item item) {
		return imp.remove(item);
	}

}
