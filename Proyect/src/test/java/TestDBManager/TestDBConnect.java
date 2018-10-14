package TestDBManager;


import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import org.junit.Test;

import DBManager.DBConnect;
import DBManager.Database;

public class TestDBConnect {
	@Test
	public void connecttest(){
		Database db = new Database("root", "masterkey", "pridestoretest");
		DBConnect dbconnection = new DBConnect();
		Connection connected =  dbconnection.conn(db);
		assertTrue(connected != null);
	}
}
