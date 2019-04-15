package com.topicfive.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuiteClasses({ UserController.class })
public class UserControllerTest {

	UserController controller;

	@Mock
	private UserRepository repository;

	User userOne = new User("John20x", "John", "123");
	User userUpdate = new User("Johnx200", "John", "321");

	@Before
	public void loadDatabase() {
		controller = new UserController(repository);
		when(repository.findByName(userOne.getName())).thenReturn(userOne);
		when(repository.save(userOne)).thenReturn(userOne);
		when(repository.findByUsername(userOne.getUsername())).thenReturn(userOne);

	}

	@Test
	public void testGetUserByNameMethod() {
		assertEquals(userOne, controller.getUserByName("John"));
	}

	@Test
	public void testGetUserByUsernameMethod() {
		assertEquals(userOne, controller.getUserByUsername("John20x"));
	}

	@Test
	public void testRegisterUserMethod() {
		when(repository.findByUsername(userOne.getUsername())).thenReturn(null);
		assertEquals(userOne, controller.registerUser(userOne));
	}

	@Test
	public void testUpdateUserMethod() {
		controller.updateUser(userOne, userUpdate);
		assertEquals(userOne.getUsername(), "Johnx200");
	}

}