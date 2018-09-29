package com.mathiastechera.abstractfactory.factory;

public class History implements SubjectDB {

	@Override
	public void getTheSchedule() {
		//connect with the DB and return the schedule of the subject.
		System.out.println("History: Monday at 19:00, Tuesday at 17:00");

	}

}
