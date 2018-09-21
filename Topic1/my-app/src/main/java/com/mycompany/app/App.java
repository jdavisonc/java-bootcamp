package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(getHelloWorld());
    }
	public static String getHelloWorld() {

		return "Hello World";

	}
    public static boolean negate(boolean x){
        return !x;
    }
}
