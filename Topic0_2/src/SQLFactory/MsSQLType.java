package SQLFactory;

public class MsSQLType extends SQLType{
	@Override
	public Connection getConnection(String type) {
/*code for Microsoft SQL Connection*/
		return con;
	}
}
