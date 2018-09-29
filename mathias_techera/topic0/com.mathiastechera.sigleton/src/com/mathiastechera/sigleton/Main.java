package com.mathiastechera.sigleton;
import com.mathiastechera.connection.*;

public class Main {

	public static void main(String[] args) {

		Database db = Database.getInstance();
		
		if(db.connect()) {
			System.out.println("Connected succesfully.");
		}else {
			System.out.println("Error connecting with the DB.");
		}
		
	}
	
}
