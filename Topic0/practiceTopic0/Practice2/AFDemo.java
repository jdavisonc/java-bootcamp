package practiceTopic0.Practice2;

public class AFDemo {
	public static void main(String[] args) {
		AbstractFactory demoFactory = FactoryProducer.getFactory("FACTORY1");

		SqlConnection demoConnection1 = demoFactory.getConnection("TYPE1");

		demoConnection1.Connect();

		SqlConnection demoConnection2 = demoFactory.getConnection("TYPE2");

		demoConnection2.Connect();

		AbstractFactory demoFactory2 = FactoryProducer.getFactory("FACTORY2");

		SqlConnection demoConnection3 = demoFactory2.getConnection("TYPE3");

		demoConnection3.Connect();

		SqlConnection demoConnection4 = demoFactory2.getConnection("TYPE4");

		demoConnection4.Connect();

	}

}

/*
 * THE OUTPUT FOR THIS DEMONSTRATION is:
 * 
 * This is the first type of SQL Connection. #1 This is the second type of SQL
 * Connection. #2 This is the third type of SQL Connection. #3
 * 
 */