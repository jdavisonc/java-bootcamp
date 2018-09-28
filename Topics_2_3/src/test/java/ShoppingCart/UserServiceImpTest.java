package ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserServiceImpTest {
	Database databaseConnection = new Database();
	UserServiceImp service = new UserServiceImp(databaseConnection);

	@Test
	void testRegisterUserAndShowUserData() {
		service.registerUser("Thomas", "123", "5.796.678-3", "23374263", "thomas@gmail.com");
		assertEquals(databaseConnection.userDatabase.get(0).toString(), service.showUserData("5.796.678-3"));
	}

	@Test
	void testUpdateUser() {
		service.registerUser("John", "1234", "4.256.632-2", "34563421", "john@gmail.com");
		service.updateInfo("John", "1234", "34563421", "john1001@gmail.com");
		assertEquals(databaseConnection.userDatabase.get(0).getEmail(), "john1001@gmail.com");
	}
}
