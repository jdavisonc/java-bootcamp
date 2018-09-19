package userService;

import java.util.HashMap;

public class UserServiceImpl implements UserService{
	
	private HashMap<String, User> users = new HashMap<String, User>();

	public User createUser(String name, String lastName, String email) {
		User user = new User(name, lastName, email);
		users.put(email, user);
		return user;
	}

	public void deleteUser(String email) {
		users.remove(email);
	}

	public User updateUser(String email, User user) {
		users.put(email, user);
		return user;
	}

	public User getUser(String email) {
		return users.get(email);
	}

	

}
