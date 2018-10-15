package cartRequest;

public class cartitems {

	String prodName;
	float prodPrice;
	public cartitems(String prodName, float prodPrice) {
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}
	
}
