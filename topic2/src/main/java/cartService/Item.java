package cartService;

public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name+" - $" + this.price;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	
}
