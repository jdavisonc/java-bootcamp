package com.mathiastechera.project.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mathiastechera.project.item.CartItem;


public interface CartRepository extends JpaRepository<Cart, Long> {
	/**
	 * Search the Cart by the id of the buyer ID
	 * @param The buyer ID 
	 * @return Returns an List of Cart that has a certain buyer id 
	 */	
	@Query("select p from Cart p where p.buyerID = ?1")
	List<Cart> findByBuyerID(Integer buyerID);
	
	
}
