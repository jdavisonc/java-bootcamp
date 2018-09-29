package topic5.cartService;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import topic5.ItemNotFoundException;

@RestController
public class CartServiceImpl implements CartService {
	
	
	private int id = 0;
	
	private HashMap<Integer, Item> items = new HashMap<Integer, Item>();

	@GetMapping("/items")
	public Collection<Item> getItems() {
		return this.items.values();
	}

	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		item.setId(id);
		this.items.put(id, item);
		id++;
		return item;
	}

	@DeleteMapping("/items/empty")
	public void emptyCart() {
		this.items.clear();
	}

	@GetMapping("/items/price")
	public int price() {
		int result = 0;
		for (Item item : this.items.values()) {
			result += item.getPrice();
		}
		return result;
	}

	@DeleteMapping("/items/{id}")
	public boolean remove(@PathVariable int id) {
		if (items.containsKey(id)) {
			this.items.remove(id);
			return true;
		}

		throw new ItemNotFoundException();
	}

}
