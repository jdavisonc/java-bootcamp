package Practice2_alternate;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("FACTORY1")) {
			return new SqlCFactory();
		} else if(choice.equalsIgnoreCase("FACTORY2")) { 
			return new SqlC2Factory();
		}
			
		return null;
	}
}
