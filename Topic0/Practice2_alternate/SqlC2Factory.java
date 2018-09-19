package Practice2_alternate;

public class SqlC2Factory extends AbstractFactory {
	@Override
	public SqlConnection getConnection(String type) {
		if(type==null)return null;
		
		
		if(type.equalsIgnoreCase("TYPE3")) {
		return new SqlC3();
		} else if(type.equalsIgnoreCase("TYPE4")) {
		return new SqlC4();	
		}
		
		return null;	
	}
	
	
}
