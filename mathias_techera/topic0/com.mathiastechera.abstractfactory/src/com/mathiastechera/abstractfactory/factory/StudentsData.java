package com.mathiastechera.abstractfactory.factory;

public class StudentsData implements PersonDB {

	@Override
	public void getTheNames() {
		//connect with the DB trough JDBC and return the students names.
		System.out.println("The students names are: Student1, Student2, Student3");
		
	}

}
