package abstract_factory;

public abstract class DatabaseFactory {
	
	abstract DatabaseInterface getConnection(String type);

}