package login;

public class dataLogin {
	String nickName;
	String Password;
	public dataLogin(String nickName, String password) {
		this.nickName = nickName;
		this.Password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
