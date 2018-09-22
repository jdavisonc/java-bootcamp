package topic5.cartService;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartServiceImpl implements CartService {
	
	
	private int id = 0;
	private LinkedList<Item> items = new LinkedList<Item>();

	@GetMapping("/items")
	public LinkedList<Item> getItems() {
		return this.items;
	}

	@PostMapping("/items")
	public boolean addItem(@RequestBody Item item) {
		item.setId(id);
		id++;
		return this.items.add(item);
	}

	@PostMapping("/items/empty")
	public void emptyCart() {
		this.items.clear();
	}

	@GetMapping("/items/price")
	public double price() {
		double result = 0;
		for (Item item : this.items) {
			result += item.getPrice();
		}
		return result;
	}

	@DeleteMapping("/items/{id}")
	public boolean remove(@PathVariable int id) {
		for (Item item : this.items) {
			if(item.getId() == id) {
				return this.items.remove(item);
			}
		}
		return false;
	}

}
