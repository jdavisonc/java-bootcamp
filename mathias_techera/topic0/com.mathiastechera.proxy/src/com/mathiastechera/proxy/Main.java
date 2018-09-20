package com.mathiastechera.proxy;

import com.mathiastechera.db.Proxy;
import com.mathiastechera.db.SmallQuery;


public class Main {

	public static void main(String[] args) {
		//Using Proxy Pattern in a simulation of a connection to a DB with
		//a query that will delay the execution of the program.
		Proxy proxy = new Proxy();
		
		SmallQuery smallQuery = new SmallQuery();
		smallQuery.start();
		
		proxy.start();
		
	}

}
