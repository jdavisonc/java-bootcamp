package com.mathiastechera.project.item;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Item {
	
	@Id
    @GeneratedValue
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	protected String name;
	@Column(name="value")
	protected Double value;
	/**
	 * The amount of Item is the stock of an specific Item.
	 */
	@Column(name="amount")
	protected Integer amount;
	@Column(name="category")
	protected String category;
	public Item() {
		
	}
	/** 
	 * Product from the store
	 * @param name - name that identify the item
	 * @param value - price of the item
	 * @param amount - quantity of the same item
	 */
	public Item(String name, Double value, Integer amount, String category) {
		this.name = name;
		this.value = value;
		this.amount = amount;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", value=" + value + ", amount=" + amount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
		
}
