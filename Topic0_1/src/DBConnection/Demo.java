package DBConnection;

public class Demo {

	public static void main(String[] args) {
		DBConnection ConnectDB = DBConnection.getInstance();

		ConnectDB.connect();
	}
}
