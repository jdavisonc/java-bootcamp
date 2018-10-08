package proxy;

public class ProxyDatabase {
	Database db;
	
	public void connect() {
		if (db == null) {
			db = new Database();
		}
		db.connect();
	}
	
	public int[]  getData() {
		return db.getData();
	}
	
	
}