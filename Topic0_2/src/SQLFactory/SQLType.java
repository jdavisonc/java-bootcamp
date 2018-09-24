package SQLFactory;

import java.sql.Connection;

public abstract class SQLType {
	public abstract Connection getConnection(String type);
}
