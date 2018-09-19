package practiceTopic0.Practice1;

//1: Create a singleton example for a database connection.
public class SingletonDBC { 

	private static SingletonDBC singletonDBC=null;
	
	private SingletonDBC () {
		//private constructor utilized in the getInstance method.
	}
	
	public static SingletonDBC getInstance() {
		if(singletonDBC==null) {
			singletonDBC = new SingletonDBC();
		} return singletonDBC;
	} //only lets one instance to be generated for the database connection
	
}
