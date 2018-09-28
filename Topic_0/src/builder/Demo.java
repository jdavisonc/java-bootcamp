package builder;

public class Demo {
	public static void main(String[] args) {
		
		
		ConnectionBuilder requestDatabase = new AccountsDatabase();
		DatabaseDirector dtbDirector = new DatabaseDirector(requestDatabase);
		MysqlDatabase establishConnection1 = dtbDirector.getDatabase();

		System.out.println(establishConnection1);

		requestDatabase = new ClientsDatabase();
		dtbDirector = new DatabaseDirector(requestDatabase);
		MysqlDatabase establishConnection2 = dtbDirector.getDatabase();

		System.out.println(establishConnection2);

	}
}