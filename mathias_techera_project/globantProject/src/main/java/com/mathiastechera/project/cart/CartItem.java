package com.mathiastechera.project.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CartItem")
@Table(name = "cartitem")
public class CartItem {
	@Id
    @GeneratedValue
    @Column(name="id")
	private Integer id;
	@Column(name="buyerid")
	private Integer buyerID;
	@Column(name="cartid")
	private Long cartID;
	@Column(name="purchaseid")
	private Long purchaseID;
	@Column(name="itemid")
	private Integer itemID;
	@Column(name="amount")
	private Integer amount;
	@Column(name="unitvalue")
	private Double unitValue;
	
	
	public CartItem() {	
	}
	/**
	 * The amount of CartItem is the amount of an specific Item in the Cart.
	 */
	public CartItem( Integer buyerID, Long cartID , Integer itemID, Integer amount, Double unitValue) {
		this.buyerID = buyerID;
		this.cartID = cartID;		
		this.itemID = itemID;
		this.amount = amount;
		this.unitValue = unitValue;
	}

	public Integer getBuyerID() {
		return buyerID;
	}

	public Long getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(Long purchaseID) {
		this.purchaseID = purchaseID;
	}
	public Integer getItemID() {
		return itemID;
	}
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}
	public void setBuyerID(Integer buyerID) {
		this.buyerID = buyerID;
	}

	public Long getCartID() {
		return cartID;
	}

	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}
	

	/**
	 * Increase the current amount of this item in a certain quantity
	 * @param amount - quantity of the increase
	 */
	public void increaseAmount(Integer amountToAdd) {
		this.amount+= amountToAdd;
	}

	/**
	 * Decrease the current amount of this item in a certain quantity
	 * @param amount - quantity of the decrease
	 */
	public void decreaseAmount(Integer amountToRemove) {
		this.amount = this.amount - amountToRemove;
	}

	/**
	 * Returns the total value of the amount of items
	 * @return
	 */
	public Double getTotalValue() {
		return unitValue * amount;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", buyerID=" + buyerID + ", cartID=" + cartID + ", itemID=" + itemID + ", amount="
				+ amount + ", unitValue=" + unitValue + "]";
	}
	
}
