package proxy;

public class User {
	String userName;
	String password;
	boolean admin;

	public User(String name, String pass, boolean fullPermission) {
		this.userName = name;
		this.password = pass;
		this.admin = fullPermission;
	}

	/*
	 * The following method will determine if the user is allowed to access certain
	 * methods
	 */

	public boolean hasAccess() {
		boolean access = false;
		if (this.admin == true) {
			access = true;
		}
		return access;
	}
}