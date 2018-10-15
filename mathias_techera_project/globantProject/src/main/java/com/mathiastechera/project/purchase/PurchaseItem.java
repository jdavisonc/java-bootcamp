package com.mathiastechera.project.purchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PurchaseItem")
@Table(name = "purchaseitem")
public class PurchaseItem {
	@Id
    @GeneratedValue
    @Column(name="id")
	private Integer id;
	@Column(name="buyerid")
	private Integer buyerID;
	@Column(name="purchaseid")
	private Long purchaseid;
	@Column(name="itemid")
	private Integer itemID;
	@Column(name="amount")
	private Integer amount;
	@Column(name="unitvalue")
	private Double unitValue;
	
	
	public PurchaseItem() {	
	}
	/**
	 * The amount of PurchaseItem is the amount of an specific Item in the Purchase.
	 */
	public PurchaseItem( Integer buyerID, Long purchaseid , Integer itemID, Integer amount, Double unitValue) {
		this.buyerID = buyerID;
		this.purchaseid = purchaseid;		
		this.itemID = itemID;
		this.amount = amount;
		this.unitValue = unitValue;
	}

	public Integer getBuyerID() {
		return buyerID;
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

	public Long getpurchaseid() {
		return purchaseid;
	}

	public void setpurchaseid(Long purchaseid) {
		this.purchaseid = purchaseid;
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
		return "PurchaseItem [id=" + id + ", buyerID=" + buyerID + ", purchaseid=" + purchaseid + ", itemID=" + itemID + ", amount="
				+ amount + ", unitValue=" + unitValue + "]";
	}
	
}
