package userCrud;

public class usersCRUD {
	String userName;
	String email;
	String phone;
	String address;
	String nickName;
	String password;

	public usersCRUD(String userName, String email, String phone, String address, String nickName, String password) {
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.nickName = nickName;
		this.password = password;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
