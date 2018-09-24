package SQLFactory;

public class AbstractFactory {
	public SQLType getSQLType(String type) {
		if ("MySQL".equalsIgnoreCase(type)) {
			return new MySQLType();
		}	else {
				return new MsSQLType();
			}
	}
}
