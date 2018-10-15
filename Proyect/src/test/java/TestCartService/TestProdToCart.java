package TestCartService;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import DBManager.Database;
import cartservice.prodToCart;
import cartservice.product;


public class TestProdToCart {

	Database db = new Database("root", "masterkey", "pridestoretest");
	@Test
	public void insert2Data() {
		product prod = new product(3,3);
		assertTrue(prodToCart.addProd(prod, db));
	}
	
}
