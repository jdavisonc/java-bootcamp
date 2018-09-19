package practiceTopic0.Practice4;

public class Connection {

		private String user;
		private String password;
		private String db;

		public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getDb() {
			return db;
		}


		public void setDb(String db) {
			this.db = db;
		}



		public String toString() {
			return "user:" + user + ", password:" + password + ", db:" + db;
		}

	
}
