package com.mathiastechera.project.purchase;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Purchase {

	@Id
    @GeneratedValue
    @Column(name="id")
	private Long id;
	@OneToMany(
        cascade = CascadeType.ALL, 
        orphanRemoval = true
        )
	@JoinColumn(name = "purchaseid")
	private Set<PurchaseItem> purchaseItems = new HashSet<PurchaseItem>();
	
	 
	@Column(name="buyerid")
	private Integer buyerID;
	@Column(name="finalprice")
	private Double finalPrice = 0.0; 
	
	public Long getId() {
		return id;
	}
	
	public Set<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	public void addPurchaseItems(PurchaseItem purchaseItem) {
		this.purchaseItems.add(purchaseItem);
	}

	public void setPurchaseItemsFromCart(Set<PurchaseItem> cartItems) {
//		Iterator value = (Iterator) cartItems.iterator();
//		while(value.hasNext()) {			
//			PurchaseItem purchaseitem = new PurchaseItem( , Long cartID , Integer itemID, Integer amount, Double unitValue);
//			this.purchaseItems.add(purchaseitem);
//		}
//		this.purchaseItems purchaseItems;
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

}
