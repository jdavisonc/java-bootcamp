package com.mathiastechera.db;
import java.util.Date;

public abstract class Connection {

	public void start() {
		
		System.out.println(this.getClass().getSimpleName() + " connected with the DB at " + new Date());
	}
	
}
