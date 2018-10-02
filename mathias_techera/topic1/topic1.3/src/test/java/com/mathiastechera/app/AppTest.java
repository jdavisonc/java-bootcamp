package com.mathiastechera.app;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import com.mathiastechera.app.App;

public class AppTest {

    protected int value1;
    protected int value2;

    
    @Before
    protected void setUp(){
        value1 = 5;
        value2 = 3;
    }

    /**
     * Test the add method
     */
    @Test
    public void testAppAdd()
    {
        App app = new App();
        int result = app.add(value1, value2);
        assertTrue( result == 8 );
    }
}
