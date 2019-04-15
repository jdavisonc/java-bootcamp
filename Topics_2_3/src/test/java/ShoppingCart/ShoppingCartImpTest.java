package ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartImpTest {

	ShoppingCartImp cart;
	Database database;

	// Reinstantiating cart and database object so I can run the test from scratch

	@BeforeEach
	public void newCart() {
		cart = new ShoppingCartImp();
	}

	@Test
	void testAddingItemsToCart() {

		database = cart.databaseConnection;
		cart.putItems(database.productList.get(1), 3);
		assertEquals(cart.getProductList().get(0), database.productList.get(1));
	}

	@Test
	void testDeletingItemsInCart() {
		database = cart.databaseConnection;
		cart.deleteItems(database.productList.get(1), 3);
		assertEquals(-1, cart.getProductList().indexOf(database.productList.get(1)));

	}

	@Test
	void testUpdateItemsInCart() {
		database = cart.databaseConnection;
		cart.putItems(database.productList.get(2), 3);
		cart.updateItems(database.productList.get(2), 5);
		assertEquals(5, cart.getProductList().get(0).getDesiredQuantity());
	}

	@Test
	void testCalculateTotalPriceInCart() {
		database = cart.databaseConnection;
		cart.putItems(database.productList.get(2), 3);
		assertEquals(60, cart.getTotalPrice());
	}
}