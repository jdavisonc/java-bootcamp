package ShoppingCart;

/**
 * This class contains the implementation for UserService CRUD operations.
 * 
 * @author Victor Munareto
 *
 */
public class UserServiceImp implements UserService {

	Database databaseConnection;

	/**
	 * The constructor creates an instance of the class and connects it with the
	 * database.
	 * 
	 * @param database
	 */
	public UserServiceImp(Database database) {
		this.databaseConnection = database;
	}

	/**
	 * This method registers a new user to the database with the given information.
	 * 
	 * @param name
	 * @param password
	 * @param document
	 * @param telephone
	 * @param email
	 */
	@Override
	public String registerUser(String name, String password, String document, String telephone, String email) {

		databaseConnection.userDatabase.add(new User(name, password, document, telephone, email));
		return "User added succesfully";
	}

	/**
	 * Shows the data for a user with the given document ID and returns the data as
	 * a string
	 * 
	 * @param userDocument
	 */
	@Override
	public String showUserData(String userDocument) {
		String userInfo = "User doesn't exist";
		for (User user : databaseConnection.userDatabase) {
			if (user.getDocument().equalsIgnoreCase(userDocument)) {
				userInfo = user.toString();
			}
		}
		return userInfo;
	}

	/**
	 * Updates the telephone and email of a given user account.
	 * 
	 * @param userName
	 * @param password
	 * @param newTelephone
	 * @param newEmail
	 */
	@Override
	public void updateInfo(String userName, String password, String newTelephone, String newEmail) {
		for (User user : databaseConnection.userDatabase) {
			if (user.getName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
				user.setEmail(newEmail);
				user.setTelephone(newTelephone);
			}
		}
	}

	/**
	 * Deletes a user with given account.
	 * 
	 * @param userName
	 * @param password
	 */
	@Override
	public void deleteUser(String userName, String password) {
		for (User user : databaseConnection.userDatabase) {
			if (user.getName().equals(userName) && user.getPassword().equals(password)) {
				databaseConnection.userDatabase.remove(user);
			}
		}

	}
}
