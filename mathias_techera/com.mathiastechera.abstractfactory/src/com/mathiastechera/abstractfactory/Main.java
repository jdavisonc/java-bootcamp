package com.mathiastechera.abstractfactory;
import com.mathiastechera.abstractfactory.factory.PersonDB;
import com.mathiastechera.abstractfactory.factory.SubjectDB;
import com.mathiastechera.abstractfactory.factory.AbstractFactory;
import com.mathiastechera.abstractfactory.factory.FactoryProducer;



public class Main {

	public static void main(String[] args) {
		
		AbstractFactory personsDataFactory = FactoryProducer.getFactory("PersonsData");

		PersonDB studentsData = personsDataFactory.getPersonsData("Student");
		studentsData.getTheNames();
		
		PersonDB teachersData =  personsDataFactory.getPersonsData("Teacher");		
		teachersData.getTheNames();
		
		AbstractFactory subjectFactory = FactoryProducer.getFactory("Subject");
		
		SubjectDB math = subjectFactory.getSubjectData("Mathematics");
		math.getTheSchedule();
		SubjectDB history = subjectFactory.getSubjectData("History");
		history.getTheSchedule();

	}

}
