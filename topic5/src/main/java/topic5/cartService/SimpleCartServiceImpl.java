package topic5.cartService;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleCartServiceImpl implements SimpleCartService {
	
	private LinkedList<String> items = new LinkedList<String>();

	@Override
	@RequestMapping("/simple/getitems")
	public LinkedList<String> getItems() {
		return items;
	}
	
	@Override
	@RequestMapping("/simple/addItem/{item}")
	public boolean addItem(@PathVariable String item) {
		items.add(item);
		return true;
	}

	@Override
	@RequestMapping("/simple/emptyCart")
	public void emptyCart() {
		items.clear();
	}

	@Override
	@RequestMapping("/simple/price")
	public double price() {
		return 0;
	}
	
	@Override
	@RequestMapping("/simple/remove/{item}")
	public boolean remove(@PathVariable String item) {
		if (this.items.contains(item)) {
			this.items.remove(item);
		}
		return false;
	}

}
