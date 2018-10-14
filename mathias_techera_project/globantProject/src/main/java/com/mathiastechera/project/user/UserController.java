package com.mathiastechera.project.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
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
			if(userSearched.get(0).getPassword() == userLogin.getPassword()) {
				return ResponseEntity.ok(userSearched);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}
						
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	
	
}
