package cartService;
import java.util.LinkedList;

public class Demo {

	public static void main(String[] args) {
		
//		MockupItems
		Item apple = new Item("apple", 2);
		Item orange = new Item("orange", 1);
		Item iPhone = new Item("iphone", 1000);
		
		CartService service = new CartServiceImpl();
		
		service.addItem(apple);
		service.addItem(orange);
		System.out.println(service.price());
		LinkedList<Item> items = service.getItems();
		System.out.println(items.toString());
		service.emptyCart();
		System.out.println(service.price());
		service.addItem(iPhone);
		System.out.println(service.price());
		service.remove(iPhone);
		System.out.println(service.price());

	}

}
