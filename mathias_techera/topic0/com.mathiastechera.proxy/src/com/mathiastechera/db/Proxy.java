package com.mathiastechera.db;
import java.util.Date;
public class Proxy {
	
	BigQuery bigQuery;
	
	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}
	
	public void start() {
		if (bigQuery == null) {
			bigQuery = new BigQuery();
		}
		bigQuery.start();
	}
}
