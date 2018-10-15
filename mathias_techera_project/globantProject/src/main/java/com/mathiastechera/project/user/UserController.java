package com.mathiastechera.project.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	/**
	 * @return All the users
	 */
	@GetMapping("/Users")
	List<User> allUsers() {
		return repository.findAll();		
	}
	
	/**
	 * Creates a new user if the username is new.
	 * @param newUser
	 * @return returns the User created.
	 */
	@PostMapping("/signup")
	ResponseEntity<User> newUser(@RequestBody User newUserData) {
		if( newUserData.getPassword() != null && newUserData.getUsername() != null ) {
			List<User> userSearched = repository.findByUsername(newUserData.getUsername());
			if (userSearched.size() != 0) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}else {				
				return ResponseEntity.ok(repository.save(newUserData));
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}


	/**
	 * Verify if the username and the password are correct
	 * @param userLogin
	 * @return Returns the user if the credentials are correct
	 */
	@PostMapping("/login")
	ResponseEntity<List<User>> login(@RequestBody User userLogin) {
		List<User> userSearched = repository.findByUsername(userLogin.getUsername());
		if (userSearched.size() == 1) {
			if(userSearched.get(0).getPassword().compareTo(userLogin.getPassword()) == 0) {
				return ResponseEntity.ok(userSearched);
			}else {
				
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}
						
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	

	/**
	 * Logout the user
	 * @param userLoout
	 * @return returns 200 if the token is valid, 403 in other cases.
	 */
	@PostMapping("/logout")
	ResponseEntity<List<User>> logout(@RequestBody User userLogout) {
		List<User> userSearched = repository.findByUsername(userLogout.getUsername());
		if (userSearched.size() == 1) {
			if(userSearched.get(0).getToken() == userLogout.getToken()) {
				return ResponseEntity.ok(null);
			}else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			}
						
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
		
		
	}

	/**
	 * Change the attributes of an existing user. 
	 * @param newUserData - User Information to be changed. It will check the User object structure.
	 * @param username - ID of the user to be updated.
	 * @return the user updated.
	 */
	@PutMapping("/user/{username}")
	ResponseEntity<User> replaceUser(@RequestBody User newUserData, @PathVariable String username) {	
		List<User> userToUpdate = repository.findByUsername(username);
				
		if(newUserData.getFname() != null && newUserData.getLname() != null && newUserData.getEmail() != null && newUserData.getPassword() != null && newUserData.getUsername() != null && newUserData.getUsername().compareToIgnoreCase(username) == 0 ) {
				if(userToUpdate.size() == 1) {				
					userToUpdate.get(0).setFname(newUserData.getFname());
					userToUpdate.get(0).setLname(newUserData.getLname());
					userToUpdate.get(0).setEmail(newUserData.getEmail());
					userToUpdate.get(0).setPassword(newUserData.getPassword());
					return ResponseEntity.ok(repository.save(userToUpdate.get(0)));
				}else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);				
			}
	}
	

	/**
	 * Delete a certain user by his username
	 * @param username
	 */
	@DeleteMapping("/user/{username}")
	ResponseEntity<List<User>> deleteUser(@PathVariable String username) {
		List<User> userSearched = repository.findByUsername(username);
		if (userSearched.size() == 1) {
			repository.deleteById(userSearched.get(0).getId());
			return ResponseEntity.ok(userSearched);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
}
