package com.mathiastechera.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.mathiastechera.app.App;

public class AppTest 
    extends TestCase
{

    protected int value1;
    protected int value2;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    protected void setUp(){
        value1 = 5;
        value2 = 3;
    }

    /**
     * Test the add method
     */
    public void testAppAdd()
    {
        App app = new App();
        int result = app.add(value1, value2);
        assertTrue( result == 8 );
    }
}
