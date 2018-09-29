package com.mathiastechera.abstractfactory.factory;

public class Mathematics implements SubjectDB {

	@Override
	public void getTheSchedule() {
		//connect with the DB and return the schedule of the subject.
		System.out.println("Mathematics: Monday at 17:00, Tuesday at 19:00");				
	}	

}
