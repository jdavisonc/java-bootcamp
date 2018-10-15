package com.mathiastechera.project.cart;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathiastechera.project.item.CartItem;
import com.mathiastechera.project.user.User;

@RestController
public class CartController {
	private final CartRepository repository;

	CartController(CartRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * @return All the Items
	 */
	@GetMapping("/cart/getAll")
	List<Cart> allItems() {
		return repository.findAll();		
	}
	
	/**
	 * Ask for a user to search his shopping cart.
	 * TODO implement a token for different carts for the same user in different sessions.
	 * @param user
	 * @return a Cart object.
	 */
	@PostMapping("/cart/show")
	ResponseEntity<Cart> showCart(@RequestBody User user) {
		if(user.getId() != null ) {
			List<Cart> cartSearched = repository.findByBuyerID(user.getId());
			if (cartSearched.size() == 1) {				
				return ResponseEntity.ok(cartSearched.get(0));
			}else if(cartSearched.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	

	@PutMapping("/cart/add/")
	ResponseEntity<Cart> addItem(@RequestBody CartItem cartitem) {
		
		if( cartitem.getBuyerID() != null && cartitem.getAmount() != null && cartitem.getItemID() != null && cartitem.getUnitValue() != null ) {			
			if(cartitem.getCartID() != null) {
				Optional<Cart> cartSearched = repository.findById(cartitem.getCartID());			
				if (cartSearched.isPresent()) {			
					cartSearched.get().addItem(cartitem);			
					return ResponseEntity.ok(repository.save(cartSearched.get()));			
				}else {			
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			}else {
				Cart cart = new Cart();
				cart.setBuyerID(cartitem.getBuyerID());
				repository.save(cart);
				cartitem.setCartID(cart.getId());
				cart.addItem(cartitem);				
				return ResponseEntity.ok(cart);
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
