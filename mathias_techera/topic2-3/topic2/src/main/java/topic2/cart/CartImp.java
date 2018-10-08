package topic2.cart;

import java.util.ArrayList;

public class CartImp implements CartService {
	
	private ArrayList<Item> cart = new ArrayList<Item>();
	
		
	
	/**
	 * Adds an item to the cart. If the new item has the same name
	 * and the same value of a current item on the cart, the amount 
	 * of the current item will be modified for the sum of the 2 
	 * items quantities.
	 * @param itemToAdd - Item to be added
	 * @return Returns true if the item has been added as new item or increased the amount of an existing item.
	 */	
	public boolean addItem(Item itemToAdd) {
		boolean isANewItem = true;
		boolean added = false;
		for (Item itemSaved : cart) {			
			if(itemSaved.equals(itemToAdd)) {
				itemSaved.increaseAmount(itemToAdd.getAmount());
				isANewItem = false;
				added = true;
			}
		}
		if(isANewItem) {
			this.cart.add(itemToAdd);
			added = true;
		}
		return added;
	}
	
	/**
	 * If the amount of the item to be removed is less than the amount
	 * that the item on the cart has, the quantity will be decreased.
	 * If not, the item will be removed from the cart.
	 * @param itemToRemove - Item that will be removed.
	 * @return Returns true if the cart had the item to be removed.  
	 */
	public boolean removeItem(Item itemToRemove) {
		boolean removed = false; 
		for (int i = 0; i < cart.size(); i++) {
			if(cart.get(i).equals(itemToRemove)) {
				if(cart.get(i).getAmount() <= itemToRemove.getAmount()) {
					cart.remove(i);
				}else {
					cart.get(i).decreaseAmount(itemToRemove.getAmount());
				}
				removed = true;
			}
		}
		return removed;
	}
	
	/**
	 * Remove all items from the cart.
	 */
	public void emptyCart() {
		this.cart.clear();
	}

	/**
	 * Calculate the total price of all the items in the cart.
	 */
	public double getFinalPrice() {
		double finalPrice = 0.0;
		for (Item item : cart) {
			finalPrice+= item.getTotalValue();
		}
		return finalPrice;
	}
	/**
	 * Returns the amount of different types of items.
	 * Items with different name or value.
	 * @return Amount of different items.
	 */
	public int getAmountOfDifferentItems() {
		return cart.size();
	}
	
	/**
	 * Returns the amount of items in the cart.
	 * @return Amount of items
	 */
	public int getAmountOfItems() {
		int amount = 0;
		for (Item item : cart) {
			amount += item.getAmount();
		}
		return amount;
	}
	
	@Override
	public String toString() {
		return "CartImp [cart=" + cart + "]";
	}
	
	
}
