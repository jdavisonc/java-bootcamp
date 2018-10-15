package com.mathiastechera.project.item;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mathiastechera.project.item.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	/**
	 * Search users by item name
	 * @param name - Item name 
	 * @return Returns an List of Item that has a certain name 
	 */	
	@Query("select p from Item p where upper(p.name) like upper(?1)")
	List<Item> findByName(String name);
	
	/**
	 * Search users by category
	 * @param category 
	 * @return Returns an List of Item that has a certain category 
	 */	
	@Query("select p from Item p where upper(p.category) like upper(?1)")
	List<Item> findByCategory(String category);
	

}
