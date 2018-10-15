package com.mathiastechera.project.item;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathiastechera.project.item.Item;
import com.mathiastechera.project.item.ItemRepository;

@RestController
@RequestMapping(value="/item")
public class ItemController {
	private final ItemRepository repository;

	ItemController(ItemRepository repository) {
		this.repository = repository;
	}

	/**
	 * @return All the Items
	 */
	@GetMapping("/getAll")
	List<Item> allItems() {
		return repository.findAll();		
	}
	
	/**
	 * Creates a new item if the name is new.
	 * @param newItemData
	 * @return returns the Item created.
	 */
	@PostMapping("/")
	ResponseEntity<Item> newItem (@RequestBody Item newItemData) {
		if( newItemData.getAmount() != null && newItemData.getCategory() != null && newItemData.getName() != null && newItemData.getValue() != null) {
			List<Item> itemSearched = repository.findByName(newItemData.getName());
			if (itemSearched.size() != 0) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}else {				
				return ResponseEntity.ok(repository.save(newItemData));
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}



	/**
	 * Return the Item with a certain name. It is not case sensitive
	 * @param itemname Name of the item. Use '-' instead of spaces.
	 * @return The data of the item found.
	 */
	@GetMapping("/byName/{itemname}")
	ResponseEntity<List<Item>> getItemByName(@PathVariable String itemname) {
		itemname = itemname.replaceAll("-", " ");
		List<Item> lista = repository.findByName(itemname);
		if( lista.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else if (lista.size() == 1){
			return ResponseEntity.ok(lista);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Return the Item with a certain name. It is not case sensitive
	 * @param itemname Name of the item. Use '-' instead of spaces.
	 * @return The data of the item found.
	 */
	@PutMapping("/byName/{itemname}")
	ResponseEntity<Item> updateItemByName(@RequestBody Item newItemData, @PathVariable String itemname) {
		itemname = itemname.replaceAll("-", " ");
		if(newItemData.getAmount() != null && newItemData.getCategory() != null && newItemData.getName() != null && newItemData.getValue() != null) {
			List<Item> itemToUpdate = repository.findByName(itemname);
			if( itemToUpdate.size() == 1) {
				itemToUpdate.get(0).setAmount(newItemData.getAmount());
				itemToUpdate.get(0).setCategory(newItemData.getCategory());
				itemToUpdate.get(0).setValue(newItemData.getValue());
				return ResponseEntity.ok(repository.save(itemToUpdate.get(0)));
			}else if (itemToUpdate.size() == 0){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	

	/**
	 * Return the Items with a certain category. It is not case sensitive
	 * @param category Name of the category to be search. Use '-' instead of spaces.
	 * @return The data of the Items found.
	 */
	@GetMapping("/byCategory/{category}")
	ResponseEntity<List<Item>> getItemByCategory(@PathVariable String category) {
		
		category = category.replaceAll("-", " ");
		List<Item> lista = repository.findByCategory(category);
		if( lista.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			return ResponseEntity.ok(lista);
		}			
		
	}

	/**
	 * Delete a certain Item by his name
	 * @param username
	 */
	@DeleteMapping("/{itemname}")
	ResponseEntity<List<Item>> deleteItem(@PathVariable String itemname) {
		itemname = itemname.replaceAll("-", " ");
		List<Item> itemSearched = repository.findByName(itemname);
		if (itemSearched.size() == 1) {
			repository.deleteById(itemSearched.get(0).getId());
			return ResponseEntity.ok(itemSearched);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
}
