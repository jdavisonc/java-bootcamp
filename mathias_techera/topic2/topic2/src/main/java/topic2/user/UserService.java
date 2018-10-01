package topic2.user;

public interface UserService {
	
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public User getUserByDocument(String document);
	public boolean updateUser(String document, String password, String name, String lastName, String email);
}
