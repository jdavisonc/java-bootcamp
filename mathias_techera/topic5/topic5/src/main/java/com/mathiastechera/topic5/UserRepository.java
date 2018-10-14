package com.mathiastechera.topic5;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface UserRepository extends JpaRepository<User, String> {

	/**
	 * Search users by first name and last name
	 * @param fname First Name
	 * @param lname Last Name
	 * @return Returns an List of User that has a certain name 
	 */	
	@Query("select p from User p where upper(p.fname) like upper(?1) and upper(p.lname) like upper(?2)")
	List<User> getByFullName(String firstName, String lastName);
	
	/**
	 * Search users by first name and last name
	 * @param fname First Name
	 * @param lname Last Name
	 * @return Returns an List of User that has a certain name 
	 */	
	@Query("select p from User p where upper(p.fname) like upper(?1)")
	List<User> findAllByName(String firstName);
	

}