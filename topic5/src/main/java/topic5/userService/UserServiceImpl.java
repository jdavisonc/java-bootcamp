package topic5.userService;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import topic5.UserNotFoundException;

@RestController
public class UserServiceImpl implements UserService {

	private LinkedList<User> users = new LinkedList<User>();

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		for (User u : users) {
			if (u.getUserName().equals(user.getUserName())) {
				return null;
			}
			if (u.getNickName().equals(user.getNickName())) {
				return null;
			}
		}
		users.add(user);
		return user;
	}
	
	@GetMapping("/users")
	public LinkedList<User> getUsers(){
		return this.users;
	}

	@DeleteMapping("/user/{userName}")
	public Boolean deleteUser(@PathVariable String userName) {
		for (User u : users) {
			if (u.getUserName().equals(userName)) {
				return this.users.remove(u);
			}
		}
		throw new UserNotFoundException();
	}

	@PostMapping("/user/updateByUserName/{userName}")
	public User updateUserByUserName(@RequestBody User user, @PathVariable String userName) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName)) {
				users.set(i, user);
				return user;
			}
		}
		throw new UserNotFoundException();
	}

	@PostMapping("/user/updateByNickName/{nickName}")
	public User updateUserByNickName(@RequestBody User user, @PathVariable String nickName) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getNickName().equals(nickName)) {
				users.set(i, user);
				return user;
			}
		}
		throw new UserNotFoundException();
	}

	@GetMapping("/user/nickName/{nickName}")
	public User getUserByNickName(@PathVariable String nickName) {
		for (User u : this.users) {
			if (u.getNickName().equals(nickName)) {
				return u;
			}
		}
		throw new UserNotFoundException();
	}

	@GetMapping("/user/userName/{userName}")
	public User getUserByUserName(@PathVariable String userName) {
		for (User u : users) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		throw new UserNotFoundException();
	}

}
