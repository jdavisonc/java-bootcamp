package userService;

public interface UserService {
	
	public User createUser(String name, String lastName, String email);
	public void deleteUser(String email);
	public User updateUser(String email, User user);
	public User getUser(String email);
	
}
