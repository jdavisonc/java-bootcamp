package findItems;

public class dataItems {
	String category;
	String productName;
	float priceprod;
	public dataItems(String productName, float priceprod, String category) {
		this.productName = productName;
		this.category = category;
		this.priceprod = priceprod;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getpriceprod() {
		return priceprod;
	}
	public void setpriceprod(float priceprod) {
		this.priceprod = priceprod;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
