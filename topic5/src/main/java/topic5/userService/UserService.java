package topic5.userService;

public interface UserService {
	User createUser(User user);

	Boolean deleteUser(String userName);

	User updateUserByNickName(User user, String nickName);

	User updateUserByUserName(User user, String userName);

	User getUserByNickName(String nickName);

	User getUserByUserName(String userName);
}
