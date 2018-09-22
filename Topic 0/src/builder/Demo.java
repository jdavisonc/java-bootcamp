package builder;

public class Demo {

	public static void main(String[] args) {
		DatabaseBuilder dbBuilder = new OracleDbBuilder();
		DatabaseDirector dbDirector = new DatabaseDirector(dbBuilder);
		dbDirector.buildDb();
		Database db = dbDirector.getDatabase();
		
		System.out.println(db.toString());

	}

}
