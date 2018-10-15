package com.mathiastechera.project.cart;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mathiastechera.project.item.CartItem;

@Entity
public class Cart {
	

	@Id
    @GeneratedValue
    @Column(name="id")
	private Long id;
	@OneToMany(
        cascade = CascadeType.ALL, 
        orphanRemoval = true
        )
	@JoinColumn(name = "cartid")
	private Set<CartItem> cartItems = new HashSet<CartItem>();
	@Column(name="buyerid")
	private Integer buyerID;
	@Column(name="finalprice")
	private Double finalPrice = 0.0; 
	
	public Long getId() {
		return id;
	}
	
	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(Integer buyerID) {
		this.buyerID = buyerID;
	}

	/**
	 * Adds an item to the cart. If the new item has the same name
	 * and the same value of a current item on the cart, the amount 
	 * of the current item will be modified for the sum of the 2 
	 * items quantities.
	 * @param itemToAdd - Item to be added
	 * @return Returns true if the item has been added as new item or increased the amount of an existing item.
	 */	
	
	public boolean addItem(CartItem itemToAdd) {
		boolean isANewItem = true;
		boolean added = false;
		for (CartItem itemSaved : cartItems) {			
			if(itemSaved.equals(itemToAdd)) {
				itemSaved.increaseAmount(itemToAdd.getAmount());
				isANewItem = false;
				added = true;
			}
		}
		if(isANewItem) {
			this.cartItems.add(itemToAdd);
			added = true;
		}
		this.setFinalPrice();
		return added;
	}
	
	/**
	 * If the amount of the item to be removed is less than the amount
	 * that the item on the cart has, the quantity will be decreased.
	 * If not, the item will be removed from the cart.
	 * @param itemToRemove - Item that will be removed.
	 * @return Returns true if the cart had the item to be removed.  
	 */
//	public boolean removeItem(CartItem itemToRemove) {
//		boolean removed = false; 
//		for (int i = 0; i < cartItems.size(); i++) {
//			cartItems.
//			if(cartItems.toArray()[i].equals(itemToRemove)) {
//				if(cartItems.toArray()[i].getAmount() <= itemToRemove.getAmount()) {
//					cartItems.remove(i);
//				}else {
//					cartItems.toArray()[i].decreaseAmount(itemToRemove.getAmount());
//				}
//				removed = true;
//			}
//		}
//		return removed;
//	}
	
	/**
	 * Remove all items from the cart.
	 */
	public void emptyCart() {
		this.cartItems.clear();
	}

	/**
	 * Calculate the total price of all the items in the cart.
	 */
	public double getFinalPrice() {
		double finalPrice = 0.0;
		for (CartItem item : cartItems) {
			finalPrice+= item.getTotalValue();
		}
		return finalPrice;
	}

	public void setFinalPrice() {
		this.finalPrice = this.getFinalPrice();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartItems=" + cartItems + ", buyerID=" + buyerID + ", finalPrice=" + finalPrice
				+ "]";
	}
	
	
}
