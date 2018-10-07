package topic2;

import static org.junit.Assert.*;

import org.junit.Test;

import topic2.user.User;
import topic2.user.UserServiceImp;

public class TestUserService {
	
		User user1 = new User( "111",  "pwdUser1" , "Jon", "Doe", "test1@example.com");
		User user2 = new User( "222",  "pwdUser2" , "Steve", "Parker", "test2@example.com");
		User user3 = new User( "333",  "pwdUser3" , "Ana", "Murdock", "test3@example.com");
		
		
	
	@Test
	public void testUserAdd() {
		UserServiceImp userService = new UserServiceImp();
		userService.addUser(user1);
		User expected = userService.getUserByDocument("111");
		
		assertTrue(user1.equals(expected));
	}
	
	@Test
	public void testAddingAnExistingUser() {
		UserServiceImp userService = new UserServiceImp();
		boolean result1 = userService.addUser(user1);
		User userDuplicated = new User( "111",  "pwdUser1" , "Jon", "Doe", "test1@example.com");
		boolean result2 = userService.addUser(userDuplicated);
				
		assertTrue(result1);
		assertFalse(result2);
	}
	
	@Test
	public void testUpdateUser() {
		UserServiceImp userService = new UserServiceImp();
		userService.addUser(user1);
		User expected = new User( "111",  "passwordChanged" , "Bob", "Hill", "newmail@example.com");
		userService.updateUser("111", "passwordChanged" , "Bob", "Hill", "newmail@example.com");
		
		assertTrue(user1.equals(expected));
	}
	
	@Test
	public void testDeleteUser() {
		UserServiceImp userService = new UserServiceImp();
		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		
		boolean result = userService.deleteUser(userService.getUserByDocument("222"));
		int amountOfUsersExpected = 2;
		
		assertTrue(result);
		assertTrue(userService.getUserDB().size() == amountOfUsersExpected);
		
	}

}
