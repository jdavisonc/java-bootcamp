package Practice2_alternate;

public abstract class AbstractFactory {
	abstract SqlConnection getConnection(String type);
} 
