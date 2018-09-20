package com.mathiastechera.abstractfactory.factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
		   
	      if(choice.equalsIgnoreCase("Subject")){
	         return new SubjectFactory();
	         
	      }else if(choice.equalsIgnoreCase("PersonsData")){
	         return new PersonsDataFactory();
	      }
	      
	      return null;
	   }
}
