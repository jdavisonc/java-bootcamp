package ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserServiceImpTest {
	Database databaseConnection = new Database();
	UserServiceImp service = new UserServiceImp(databaseConnection);
	ArrayList<User> users = databaseConnection.userDatabase;
	
	@Test
	void testRegisterUserAndShowUserData() {
		users.add(service.registerUser("Thomas", "123", "5.796.678-3", "23374263", "thomas@gmail.com"));
		assertEquals(users.get(0).toString(), service.showUserData("5.796.678-3", databaseConnection));
	}

	@Test
	void testUpdateUser() {
		users.add(service.registerUser("John", "1234", "4.256.632-2", "34563421", "john@gmail.com"));
		service.updateInfo(databaseConnection, "John", "1234", "34563421", "john1001@gmail.com");
		assertEquals(users.get(0).getEmail(), "john1001@gmail.com");
	}
}
