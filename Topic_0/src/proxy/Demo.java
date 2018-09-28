package proxy;

public class Demo {
	public static void main(String[] args) {

		/*
		 * First test: a normal user makes one request that doesn't need full
		 * permission, and another two that needs admin permissions
		 */

		User normalUser = new User("John", "123", false);

		DatabaseProxy mysqlDatabase = new DatabaseProxy(normalUser);
		System.out.println("First Test: \n");
		System.out.println("Displaying data: \n" + mysqlDatabase.showData("data1"));
		System.out.println("Deleting data... \n" + mysqlDatabase.deleteData("data1"));
		System.out.println("Displaying data: \n" + mysqlDatabase.showData("Sensitive data"));

		/*
		 * Second test: the database proxy now receives an admin user making the same
		 * requests and modifying data, but obtaining different results
		 */

		System.out.println("\nSecond Test: \n");

		User adminlUser = new User("Luke", "456", true);

		mysqlDatabase = new DatabaseProxy(adminlUser);
		System.out.println("Deleting data... \n" + mysqlDatabase.deleteData("data1"));
		System.out.println("Displaying data: \n" + mysqlDatabase.showData("data1"));

		System.out.println("Displaying data: \n" + mysqlDatabase.showData("Sensitive data"));

		System.out.println(mysqlDatabase.modifyData("data2", "newupdated"));
		System.out.println(mysqlDatabase.showData("newupdated"));
	}
}