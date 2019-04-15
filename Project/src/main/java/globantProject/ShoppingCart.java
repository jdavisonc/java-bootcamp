package globantProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShoppingCart {
	@Autowired
	ProductRepository productRepo;

	@Autowired
	UserRepository userRepo;

	@GetMapping("/searchproduct/{productname}")
	public Products searchByName(@PathVariable String productname) {
		Products product = productRepo.findByName(productname);
		return product;
	}

	@GetMapping("/searchcategory/{category}")
	public Iterable<Products> searchByCategory(@PathVariable String category) {
		Iterable<Products> products = productRepo.findByCategory(category);
		return products;
	}

	@PutMapping("/register/{username}")
	public String getAllUsers(@RequestBody User newUser, @PathVariable String username) {
		if (userRepo.findByUsername(username) == null) {
			userRepo.save(newUser);
			return "Registration successfull";
		} else {
			return "That username is taken";
		}
	}

	@PutMapping("/login/{username}")
	public User loginUser(@RequestBody User newUser, @PathVariable String username) {
		User loggedUser = userRepo.findByUsername(username);
		if (loggedUser.getPassword().equals(newUser.getPassword())) {
			return loggedUser;
		} else {
			return null;
		}
	}

	@PutMapping("/addProduct/{product}")
	public User addProduct(@RequestBody User loggedUser, @RequestBody Products newProduct) {
		User addToUserCart = userRepo.findByUsername(loggedUser.getUsername());
		addToUserCart.getProductsInCart().add(newProduct);
		return userRepo.save(addToUserCart);
	}

	@DeleteMapping("/removeProduct/{product}")
	public User removeProduct(@RequestBody User loggedUser, @RequestBody Products product) {
		User removeFromCart = userRepo.findByUsername(loggedUser.getUsername());
		removeFromCart.getProductsInCart().remove(product);
		return userRepo.save(removeFromCart);
	}

	@DeleteMapping("/clearcart")
	public User clearCart(@RequestBody User loggedUser) {
		User resetCart = userRepo.findByUsername(loggedUser.getUsername());
		resetCart.getProductsInCart().clear();
		return userRepo.save(resetCart);
	}

	@GetMapping("/buyproducts")
	public String buyProducts(@RequestBody User loggedUser) {
		User user = userRepo.findByUsername(loggedUser.getUsername());
		for (Products p : user.getProductsInCart()) {
			if (!user.getRecommended().contains(p.getCategory())) {
				user.getRecommended().add(p.getCategory());
			}
		}
		user.getProductsInCart().clear();
		return "Products purchased successfully";
	}
}
