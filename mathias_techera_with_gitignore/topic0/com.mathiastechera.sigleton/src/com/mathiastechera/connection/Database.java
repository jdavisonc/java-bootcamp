package com.mathiastechera.connection;

public class Database {

	private static Database database = null;
	
	private Database() {		
	}
	
	public static Database getInstance() {
		if(database == null) {
			database = new Database();			
		}
		return database;
	}
	
	public boolean connect() {
		boolean connected = true;
		//connect with the DB desire 
		
		return connected;
	}
}