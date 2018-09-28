package ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShoppingCartImpTest {

	ShoppingCartImp cart;
	Database database;

	// Reinstantiating cart and database object so I can run the test from scratch

	@Test
	void testAddingItemsToCart() {
		cart = new ShoppingCartImp();
		database = cart.databaseConnection;
		cart.putItems(database.productList.get(1), 3);
		assertEquals(cart.getProductList().get(0), database.productList.get(1));
	}

	@Test
	void testDeletingItemsInCart() {
		cart = new ShoppingCartImp();
		database = cart.databaseConnection;
		cart.deleteItems(database.productList.get(1), 3);
		assertEquals(-1, cart.getProductList().indexOf(database.productList.get(1)));

	}

	@Test
	void testUpdateItemsInCart() {
		cart = new ShoppingCartImp();
		database = cart.databaseConnection;
		cart.putItems(database.productList.get(2), 3);
		cart.updateItems(database.productList.get(2), 5);
		assertEquals(5, cart.getProductList().get(0).getDesiredQuantity());
	}

	@Test
	void testCalculateTotalPriceInCart() {
		cart = new ShoppingCartImp();
		database = cart.databaseConnection;
		cart.putItems(database.productList.get(2), 3);
		assertEquals(60, cart.getTotalPrice());
	}
}
