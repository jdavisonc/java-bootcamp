package com.mathiastechera.abstractfactory.factory;

public class SubjectFactory extends AbstractFactory {


	@Override
	public SubjectDB getSubjectData(String subject) {
		if(subject == null) {
			return null;
		}
		if(subject.equalsIgnoreCase("Mathematics")) {
			return new Mathematics();
		}
		if(subject.equalsIgnoreCase("HISTORY")) {
			return new History();
		}
		return null;
	}

	
	@Override
	public PersonDB getPersonsData(String personsType) {
		// TODO Auto-generated method stub
		return null;
	}

}
