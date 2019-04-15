package ShoppingCart;

public interface UserService {

	User registerUser(String name, String password, String document, String telephone, String email);

	String showUserData(String userDocument, Database databaseConnection);

	void updateInfo(Database databaseConnection, String userName, String password, String newTelephone, String newEmail);

	void deleteUser(Database databaseConnection, String userName, String password);

}
