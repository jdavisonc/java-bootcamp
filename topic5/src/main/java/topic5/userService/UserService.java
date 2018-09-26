package topic5.userService;

public interface UserService {
	User createUser(String userName, String nickName, String email);

	Boolean deleteUser(String userName);

	User updateUserByNickName(String nickName, String userName, String email);

	User updateUserByUserName(String userName, String nickName, String email);

	User getUserByNickName(String nickName);

	User getUserByUserName(String userName);
}
