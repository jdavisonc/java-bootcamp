package com.mathiastechera.project.user;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Search users by username
	 * @param username 
	 * @return Returns an List of User that has a certain username 
	 */	
	@Query("select p from User p where upper(p.username) like upper(?1)")
	List<User> findByUsername(String username);
	

}