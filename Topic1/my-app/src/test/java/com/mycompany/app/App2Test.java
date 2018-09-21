package com.mycompany.app;


import org.junit.Assert;

public class App2Test {


	public class TestApp1 {

		
		public void testPrintHelloWorld() {

			Assert.assertEquals(App.getHelloWorld(), "Hello World");

		}

	}
}
