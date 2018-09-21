package practiceTopic0.Practice2;

public class SqlCFactory extends AbstractFactory {
	@Override
	public SqlConnection getConnection(String type) {
		if(type==null)return null;
		
		
		if(type.equalsIgnoreCase("TYPE1")) {
		return new SqlC1();
		} else if(type.equalsIgnoreCase("TYPE2")) {
		return new SqlC2();	
		}
		
		return null;	
	}
	
	
}
