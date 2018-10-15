package DBManager;

public class DBConnection {

	String User;	
	String Pwd;	
	String db;
	
	public DBConnection(String user, String password, String databasename) {
		this.User = user;
		this.Pwd = password;
		this.db = databasename;
	}

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
	public String getdb() {
		return db;
	}	
	public void setdb(String db) {
		this.db = db;
	}	
}
