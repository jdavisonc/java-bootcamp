package com.mathiastechera.topic5;

import java.util.List;
import java.util.Optional;

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
	@PostMapping("/Users")
	ResponseEntity<User> newUser(@RequestBody User newUserData) {
		if(newUserData.getFname() != null && newUserData.getLname() != null && newUserData.getEmail() != null && newUserData.getPassword() != null && newUserData.getUsername() != null ) {
			Optional<User> userSearched = repository.findById(newUserData.getUsername());
			if (userSearched.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}else {
				return ResponseEntity.ok(repository.save(newUserData));
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	
	/**
	 * Return an specific user by his username
	 * @param username
	 * @return json file with the data of the user
	 */
	@GetMapping("/User/{username}")
	ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username) {
		Optional<User> userSearched = repository.findById(username);
		if (userSearched.isPresent()) {			
			return ResponseEntity.ok(userSearched);			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	
	/**
	 * Change the attributes of an existing user. If the username of the path is new, it will create a new user.
	 * @param newUserData - User Information to be changed. It will check the User object structure.
	 * @param username - ID of the user to be updated.
	 * @return the user updated.
	 */
	@PutMapping("/User/{username}")
	ResponseEntity<User> replaceUser(@RequestBody User newUserData, @PathVariable String username) {	
		Optional<User> userToUpdate = repository.findById(username);
				
		if(newUserData.getFname() != null && newUserData.getLname() != null && newUserData.getEmail() != null && newUserData.getPassword() != null && newUserData.getUsername() != null && newUserData.getUsername().compareToIgnoreCase(username) == 0 ) {
				if(userToUpdate.isPresent()) {				
					userToUpdate.get().setFname(newUserData.getFname());
					userToUpdate.get().setLname(newUserData.getLname());
					userToUpdate.get().setEmail(newUserData.getEmail());
					userToUpdate.get().setPassword(newUserData.getPassword());
					return ResponseEntity.ok(repository.save(userToUpdate.get()));
				}else {
					return ResponseEntity.ok(repository.save(newUserData));
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
	@DeleteMapping("/User/{username}")
	ResponseEntity<Optional<User>> deleteUser(@PathVariable String username) {
		Optional<User> userSearched = repository.findById(username);
		if (userSearched.isPresent()) {
			repository.deleteById(username);
			return ResponseEntity.ok(userSearched);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	/**
	 * Return the users with a certain first and last. It is not case sensitive
	 * @param username First name and last name separated with "-"
	 * @return The data of the users found.
	 */
	@GetMapping("/UserByName/{fnamelname}")
	ResponseEntity<List<User>> getUserByName(@PathVariable String fnamelname) {
		
		String[] parts = fnamelname.split("-");
		String fname = parts[0];
		List<User> lista;
		if ( parts.length == 2) {
			String lname = parts[1];
			lista = repository.getByFullName(fname, lname);
			if( lista.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}else {
				return ResponseEntity.ok(lista);
			}			
		}else if (parts.length == 1){
			
			lista = repository.findAllByName(fname);
			if( lista.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}else {
				return ResponseEntity.ok(lista);
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
