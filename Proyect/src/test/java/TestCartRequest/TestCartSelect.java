package TestCartRequest;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

import DBManager.Database;
import cartRequest.cartitems;
import cartRequest.cartselect;

public class TestCartSelect {
	
	Database db = new Database("root", "masterkey", "pridestoretest");
	//cart with only one item
	@Test
	public void findSimpleCart() {
		boolean cartCheck = true;
		ArrayList<cartitems> cartselected = new ArrayList<cartitems>();
		ArrayList<cartitems> carttest = new ArrayList<cartitems>();
		carttest.add(new cartitems((String)"Kindred Necklace",(float) 12.5));
		cartselected.addAll(cartselect.cartbuilder(1,db));
		  		int nameCheck = (carttest.get(0).getProdName().compareToIgnoreCase(cartselected.get(0).getProdName()));
		  		boolean priceCheck = (carttest.get(0).getProdPrice() == cartselected.get(0).getProdPrice());
				if (nameCheck!=0 | !priceCheck) {
					cartCheck = false;
				}
		assertTrue(cartCheck);
	}
	//cart with multiple items
	@Test
	public void findMultipleItemsCart(){
		ArrayList<cartitems> cartselected = new ArrayList<cartitems>();
		ArrayList<cartitems> carttest = new ArrayList<cartitems>();
		cartselected.addAll(cartselect.cartbuilder(2,db));
		carttest.add(new cartitems("Kindred Necklace", (float) 12.5));
		carttest.add(new cartitems("Personalized T-shirt",(float) 20.9));
		carttest.add(new cartitems("Vaporeon Plush",(float) 15.7));
		boolean carttested = true;
		int i= 0;
		for (cartitems j: cartselected) {
	  		int nameCheck = (carttest.get(i).getProdName().compareToIgnoreCase(cartselected.get(i).getProdName()));
	  		boolean priceCheck = (carttest.get(i).getProdPrice() == cartselected.get(i).getProdPrice());
			if (nameCheck!=0 & !priceCheck) {
				carttested=false;
			}
			i=i+1;
		}
		assertTrue(carttested);
	}
}
