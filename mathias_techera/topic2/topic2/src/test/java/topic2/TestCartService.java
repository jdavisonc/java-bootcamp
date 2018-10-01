package topic2;

import static org.junit.Assert.*;

import org.junit.Test;

import topic2.cart.*;

public class TestCartService {


	@Test
	public void testItemEquals() {
		Item apple = new Item("Apple", 10.0, 2);		
		Item apple2 = new Item("Apple", 10.0, 1);
		
		assertTrue(apple.equals(apple2) );
	}
	@Test
	public void test2ItemEquals() {
		Item apple = new Item("Apple", 10.0, 3);
		Item orange = new Item("Orange", 12.0, 1);		
		
		assertTrue(!apple.equals(orange) );
	}
	
	@Test
	public void testAddItemThatCartAlreadyHas() {
		CartImp cart = new CartImp();
		
		Item apple = new Item("Apple", 10.0, 1);
		Item orange = new Item("Orange", 12.0, 1);			
		Item apple2 = new Item("Apple", 10.0, 1);
		Item apple3 = new Item("Apple", 15.0, 1);
		
		cart.addItem(apple);
		cart.addItem(orange);
		cart.addItem(apple2);
		cart.addItem(apple3);		
		
		assertTrue(cart.getAmountOfDifferentItems() == 3 && cart.getAmountOfItems() == 4);
		
	}
	
	@Test
	public void testRemoveItemPartially() {
		CartImp cart = new CartImp();
		
		Item apple = new Item("Apple", 10.0, 5);
		Item orange = new Item("Orange", 12.0, 2);			
		
		Item apple2 = new Item("Apple", 10.0, 4);
		Item orange2 = new Item("Orange", 12.0, 2);
		
		cart.addItem(apple);
		cart.addItem(orange);
		cart.removeItem(orange2);
		cart.removeItem(apple2);
		
		assertTrue(cart.getAmountOfDifferentItems() == 1 && cart.getAmountOfItems() == 1);
	}
	
	@Test
	public void testGetFinalPrice() {
		CartImp cart = new CartImp();
		
		Item apple = new Item("Apple", 10.5, 1);
		Item orange = new Item("Orange", 12.2, 1);			
		Item apple2 = new Item("Apple", 10.5, 1);
		Item apple3 = new Item("Apple", 15.3, 1);
		
		cart.addItem(apple);
		cart.addItem(orange);
		cart.addItem(apple2);
		cart.addItem(apple3);
				
		assertTrue(cart.getFinalPrice()== 48.50);
		
	}
}
