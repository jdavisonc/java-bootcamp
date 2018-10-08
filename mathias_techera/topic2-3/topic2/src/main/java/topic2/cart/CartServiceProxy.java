package topic2.cart;

public class CartServiceProxy implements CartService {
	
	CartService implementation;
	
	protected CartServiceProxy(CartService imp) {
		this.implementation = imp;
	}
	public boolean addItem(Item item) {
		return this.implementation.addItem(item);
	}

	public boolean removeItem(Item item) {
		return this.implementation.removeItem(item);
	}

	public void emptyCart() {
		this.implementation.emptyCart();
	}

	public double getFinalPrice() {
		return this.implementation.getFinalPrice();
	}

	public int getAmountOfDifferentItems() {
		return this.implementation.getAmountOfDifferentItems();
	}

	public int getAmountOfItems() {
		return this.implementation.getAmountOfItems();
	}

}
