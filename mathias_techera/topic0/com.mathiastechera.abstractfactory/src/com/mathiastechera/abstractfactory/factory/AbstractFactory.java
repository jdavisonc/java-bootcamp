package com.mathiastechera.abstractfactory.factory;

public abstract class AbstractFactory {
	public abstract PersonDB getPersonsData(String personsType);
	public abstract SubjectDB getSubjectData(String subject);
	
}
