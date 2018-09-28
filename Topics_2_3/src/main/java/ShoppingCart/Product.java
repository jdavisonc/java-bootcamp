package ShoppingCart;

/**
 * Constains the properties of all products.
 * 
 * @author Victor Munareto
 *
 */
public class Product {

	private String name;
	private String category;
	private int availableQuantity;
	private int price;
	private int desiredQuantity;

	/**
	 * Constructor for every product.
	 * 
	 * @param name
	 * @param category
	 * @param availableQuantity
	 * @param price
	 */
	public Product(String name, String category, int availableQuantity, int price) {
		this.name = name;
		this.category = category;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDesiredQuantity() {
		return desiredQuantity;
	}

	public void setDesiredQuantity(int desiredQuantity) {
		this.desiredQuantity = desiredQuantity;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + ", desiredQuantity="
				+ desiredQuantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableQuantity;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		Product other = (Product) obj;
		if (this.getName().equals(other.getName()) && this.getCategory().equals(other.getCategory())) {
			isEqual = true;
		}
		return isEqual;
	}

}
