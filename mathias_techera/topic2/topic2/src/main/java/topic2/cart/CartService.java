package topic2.cart;

public interface CartService {
		
	public boolean addItem(Item item);
	public boolean removeItem(Item item);
	public void emptyCart();
	public double getFinalPrice();
	public int getAmountOfDifferentItems();
	public int getAmountOfItems();
	
}
