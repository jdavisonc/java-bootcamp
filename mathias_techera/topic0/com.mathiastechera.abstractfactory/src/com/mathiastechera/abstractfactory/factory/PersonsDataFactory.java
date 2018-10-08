package com.mathiastechera.abstractfactory.factory;

public class PersonsDataFactory extends AbstractFactory {
	

	public PersonDB getPersonsData(String personsType) {
		if(personsType == null) {
			return null;
		}
		if(personsType.equalsIgnoreCase("TEACHER")) {
			return new TeachersData();
		}
		if(personsType.equalsIgnoreCase("STUDENT")) {
			return new StudentsData();
		}
		return null;
	}
	
	@Override
	public SubjectDB getSubjectData(String subject) {
		return null;
	}

}
