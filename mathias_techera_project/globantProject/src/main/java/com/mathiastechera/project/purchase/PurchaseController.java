package com.mathiastechera.project.purchase;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathiastechera.project.cart.Cart;
import com.mathiastechera.project.cart.CartRepository;


@RestController
@RequestMapping(value="/purchase")
public class PurchaseController {
	private final PurchaseRepository purchaseRepository;
	private final CartRepository cartRepository;
	
	PurchaseController(PurchaseRepository pRepository, CartRepository cRepository) {
		this.purchaseRepository = pRepository;
		this.cartRepository = cRepository;
	}
	
	/**
	 * @return All the Items
	 */
	@GetMapping("/getAll")
	List<Purchase> allItems() {
		return purchaseRepository.findAll();		
	}
	
	/**
	 * Ask for a user to search his shopping cart.
	 * TODO implement a token for different carts for the same user in different sessions.
	 * TODO Create a new purchase, take the items from the bodyRequest and add them to purchaseItems with purchaseID. Once the purchase is complete, clear the Cart and the cartItems.
	 * @param buyerID
	 * @param purchaseItems 
	 * @return a Cart object.
	 */
	@PostMapping("/{buyerID}")
	ResponseEntity<Purchase> purchase(@RequestBody List<PurchaseItem> purchaseItems, @PathVariable Integer buyerID) {
		if(purchaseItems.size() > 0) {
			List<Cart> cartSearched = cartRepository.findByBuyerID(buyerID);
			if (cartSearched.size() == 1) {
				Purchase newPurchase = new Purchase();
				for (int i = 0; i < purchaseItems.size(); i++) {
					purchaseItems.get(i).setpurchaseid(newPurchase.getId());
					newPurchase.addPurchaseItems(purchaseItems.get(i));
					System.out.println(purchaseItems.get(i));
					System.out.println(newPurchase.getId());
					
				}
				
				
				newPurchase.setBuyerID(cartSearched.get(0).getBuyerID());
//				cartSearched.get(0).emptyCart();				
//				cartRepository.save(cartSearched.get(0));
				return ResponseEntity.ok(purchaseRepository.save(newPurchase));
				
			}else if(cartSearched.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
