package proxy;

public class DatabaseProxy implements DataRequest {

	private User registeredUser;
	private Database mysqlDatabase;

	/*
	 * When a DatabaseProxy instance is created, it receives the user making the
	 * requests
	 */
	public DatabaseProxy(User userRequesting) {
		mysqlDatabase = new Database();
		registeredUser = userRequesting;
	}

	/*
	 * The following database accesors grant limited access to users with no admin
	 * permissions. Again, strings are used to simplify the example.
	 */
	@Override
	public String showData(String request) {

		String result;
		if (request == "Sensitive data" && !registeredUser.hasAccess()) {
			result = "You don't have the required permissions";
		} else {
			result = mysqlDatabase.showData(request);
		}
		return result;
	}

	@Override
	public String deleteData(String request) {
		String result;
		if (!registeredUser.hasAccess()) {
			result = "You don't have the required permissions";
		} else {
			mysqlDatabase.deleteData(request);
			result = "Deleted successfully";
		}
		return result;
	}

	@Override
	public String modifyData(String oldData, String newData) {
		String result;
		if (!registeredUser.hasAccess()) {
			result = "You don't have the required permissions";
		} else {
			mysqlDatabase.modifyData(oldData, newData);
			result = "Data modified successfully";
		}
		return result;
	}
}
