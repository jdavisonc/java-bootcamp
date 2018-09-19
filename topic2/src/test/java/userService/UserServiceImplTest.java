package userService;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceImplTest {

	UserServiceImpl service = new UserServiceImpl();

	User john = new User("John", "Locke", "j.locke@gmail.com");
	User mike = new User("Mike", "Tyson", "m.tyson@gmail.com");
	User arnold = new User("Arnold", "Schwarzenegger", "a.schwarzenegger@gmail.com");

	@Test
	public void testCreateUser() {
		User jdoe = service.createUser("John", "Doe", "j.doe@gmail.com");
		User jdoe2 = service.getUser("j.doe@gmail.com");
		assertEquals(jdoe, jdoe2);
	}

	@Test
	public void testDeleteUser() {
		service.createUser("Arnold", "Schwarzenegger", "a.schwarzenegger@gmail.com");
		service.deleteUser("a.schwarzenegger@gmail.com");
		assertNull(service.getUser("a.schwarzenegger@gmail.com"));
	}

	@Test
	public void testUpdateUser() {
		User mikez = service.createUser("Mike", "Tyzzon", "m.tyson@gmail.com");
		User fixedMike = service.updateUser("m.tyson@gmail.com", this.mike);
		assertNotEquals(mikez, fixedMike);
	}

	@Test
	public void testGetUser() {
		User johnLocke = service.createUser("John", "Locke", "j.locke@gmail.com");

		User johnLocke2 = service.getUser("j.locke@gmail.com");

		assertEquals(johnLocke, johnLocke2);
	}

}
