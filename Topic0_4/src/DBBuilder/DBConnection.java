package DBBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private String User;
	
	private String Pwd;
	
	private String Url;
	
	public String getUser() {
		return User;
	}
	
	public void setUser(String User) {
		this.User = User;
	}
	
	public String getPwd() {
		return Pwd;
	}
	
	public void setPwd(String Pwd) {
		this.Pwd = Pwd;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setUrl(String Url) {
		this.Url = Url;
	}
	
	public void Connecting() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Url,User,Pwd);
			System.out.println("Connection Succesful");
		} catch (SQLException se) {
			System.out.println("Exception Ocurred " + se);
			
		}
	}
}

