package com.topicfive.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users/else")
@Api(value = "UsersControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/showbyname/{name}")
	@ApiOperation(value = "gets user by name")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Ok", response = User.class) })
	User getUserByName(@PathVariable String name) {
		return repository.findByName(name);
	}

	@GetMapping("/showbyusername/{username}")
	User getUserByUsername(@PathVariable String username) {
		return repository.findByUsername(username);
	}

	@PutMapping("/register")
	User registerUser(@RequestBody User newUser) {
		if (repository.findByUsername(newUser.getUsername()) == null) {
			return repository.save(newUser);
		} else {
			return null;
		}
	}

	@PutMapping("/update")
	void updateUser(@RequestBody User user, User updatedUser) {
		User retrieveUser = getUserByUsername(user.getUsername());
		retrieveUser.setUsername(updatedUser.getUsername());
		retrieveUser.setPassword(updatedUser.getPassword());
	}

	@DeleteMapping("/delete/{username}")
	void deleteUser(@RequestBody User toBeDeleted) {
		User compare = getUserByUsername(toBeDeleted.getUsername());
		if (compare != null && compare.equals(toBeDeleted.getPassword())) {
			repository.delete(toBeDeleted);
		}
	}

}
