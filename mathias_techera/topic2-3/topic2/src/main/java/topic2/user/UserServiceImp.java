package topic2.user;

import java.util.ArrayList;

public class UserServiceImp implements UserService {

	private ArrayList<User> usersDB = new ArrayList<User>();
	
	/**
	 * Search if the document doesn't exist on the usersDB. If it's new the user is added.
	 * @param user - User to be added.
	 * @return Returns true if the user is new.
	 */
	public boolean addUser(User user) {
		boolean isItNew = false;
		if(this.getUserByDocument(user.getDocument()) == null) {
			this.usersDB.add(user);
			isItNew = true;
		}
		return isItNew;
	}
	
	/**
	 * Iterates usersDB to find the user and delete it.
	 * @param user - User to be deleted
	 * @return Returns true if the user exists and has been deleted
	 */
	public boolean deleteUser(User user) {
		boolean deleted = false;
		for (int i = 0; i < usersDB.size(); i++) {
			if(usersDB.get(i).equals(user)) {
				usersDB.remove(i);
				deleted = true;
			}
		}
		return deleted;
	}
	
	/**
	 * Iterates usersDB to find the user by his document.
	 * @param document - Document of the user wanted.
	 * @return Returns the user if it exists in the collection, if not it will return null.
	 */
	public User getUserByDocument(String document) {
		for (int i = 0; i < usersDB.size(); i++) {
			if(usersDB.get(i).getDocument() == document) {
				return usersDB.get(i); 
			}
		}
		return null;
	}
	
	/**
	 * Uses getUserByDocument to find the user by his document and update the old information with the new one.
	 * @param document - Document of the user wanted
	 * @param password - new password
	 * @param name - new name
	 * @param lastName - new lastName
	 * @param email - new email
	 * @return Returns true if the user can be found and has been updated.
	 */
	public boolean updateUser(String document, String password, String name, String lastName, String email) {
		User user = this.getUserByDocument(document);
		boolean updated = false;
		if(user != null) {
			user.setEmail(email);
			user.setLastName(lastName);
			user.setName(name);
			user.setPassword(password);
			updated = true;
		}
		return updated;
	}

	@Override
	public String toString() {
		return "UserServiceImp [usersDB=" + usersDB + "]";
	}
	
	public ArrayList<User> getUserDB(){
		return new ArrayList<User> (this.usersDB);
	}

}
