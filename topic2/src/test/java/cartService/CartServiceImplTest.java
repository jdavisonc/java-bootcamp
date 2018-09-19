package cartService;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class CartServiceImplTest {

	CartServiceImpl service = new CartServiceImpl();
	Item apple = new Item("apple", 1);
	Item orange = new Item("orange", 2);
	Item iPhone = new Item("iphone", 3000);
	Item car = new Item("car", 3000000);

	@Before
	public void setUp() {
		service.addItem(apple);
		service.addItem(orange);
		service.addItem(iPhone);
	}

	@Test
	public void testGetItems() {
		LinkedList<Item> expected = new LinkedList<Item>();
		expected.add(apple);
		expected.add(orange);
		expected.add(iPhone);
		LinkedList<Item> result = service.getItems();
		assertEquals(expected, result);

	}

	@Test
	public void testAddItem() {
		LinkedList<Item> expected = service.getItems();
		expected.add(car);

		service.addItem(car);
		LinkedList<Item> result = service.getItems();

		assertEquals(expected, result);
	}

	@Test
	public void testEmptyCart() {
		service.emptyCart();
		int size = service.getItems().size();
		assertEquals(0, size);
	}

	@Test
	public void testPrice() {
		service.emptyCart();
		service.addItem(apple);
		service.addItem(car);
		service.addItem(iPhone);

		double expected = apple.getPrice() + car.getPrice() + iPhone.getPrice();
		double result = service.price();
		assertEquals(expected, result, 0.0);
	}

	@Test
	public void testRemove() {
		service.emptyCart();
		LinkedList<Item> expected = service.getItems();
		expected.add(apple);
		expected.add(car);
		service.addItem(apple);
		service.addItem(car);
		LinkedList<Item> result = service.getItems();
		assertEquals(expected, result);
		service.remove(apple);
		expected.remove(apple);
		assertEquals(expected, result);
		assertEquals(false, service.remove(apple));
	}

}
