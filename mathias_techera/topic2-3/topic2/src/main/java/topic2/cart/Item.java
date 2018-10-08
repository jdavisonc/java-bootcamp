package topic2.cart;

public class Item {
	
	protected String name;
	protected Double value;
	protected Integer amount;
	
	/** 
	 * Product from the store
	 * @param name - name that identify the item
	 * @param value - price of the item
	 * @param amount - quantity of the same item
	 */
	public Item(String name, Double value, Integer amount) {
		this.name = name;
		this.value = value;
		this.amount = amount;
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
	/**
	 * Returns the total value of the amount of items
	 * @return
	 */
	public Double getTotalValue() {
		return value * amount;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public Integer getAmount() {
		return amount;
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
