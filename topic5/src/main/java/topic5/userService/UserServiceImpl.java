package topic5.userService;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserServiceImpl implements UserService {

	private LinkedList<User> users = new LinkedList<User>();
	
	@PostMapping ("/user")
	public User createUser(@RequestParam String userName,@RequestParam String nickName,@RequestParam String email) {
		User user = new User(userName, nickName, email);
		for (User u : users) {
			if (u.getUserName() == userName) {
				return null;
			}
			if (u.getNickName() == nickName) {
				return null;
			}
		}
		users.add(user);
		return user;
	}
	@DeleteMapping ("/user/{userName}")
	public Boolean deleteUser(@PathVariable String userName) {
		for (User u : users) {
			if (u.getUserName() == userName) {
				return this.users.remove(u);
			}
		}
		return false;
	}
	@PostMapping ("/user/update/userName")
	public User updateUserByUserName(@RequestParam String userName,@RequestParam String nickName,@RequestParam String email) {
		for (User u : users) {
			if (u.getUserName() == userName) {
				u.setNickName(nickName);
				u.setEmail(email);
				return u;
			}
		}
		return null;
	}
	@PostMapping ("/user/update/nickName")
	public User updateUserByNickName(@RequestParam String nickName,@RequestParam String userName, @RequestParam String email) {
		for (User u : users) {
			if (u.getNickName() == nickName) {
				u.setUserName(userName);
				u.setEmail(email);
				return u;
			}
		}
		return null;
	}
	@GetMapping ("/user/nickName/{nickName}")
	public User getUserByNickName(@PathVariable String nickName) {
		for (User u : users) {
			if (u.getNickName() == nickName) {
				return u;
			}
		}
		return null;
	}
	@GetMapping ("/user/userName/{userName}")
	public User getUserByUserName(String userName) {
		for (User u : users) {
			if (u.getUserName() == userName) {
				return u;
			}
		}
		return null;
	}

}
