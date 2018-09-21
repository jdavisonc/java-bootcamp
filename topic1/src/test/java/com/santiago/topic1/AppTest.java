package com.santiago.topic1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.santiago.topic1.App;

public class AppTest {
	
	@Test
	public void testSum() {
		App app = new App();
		assertEquals(2, app.sum(1, 1));
		assertEquals(4, app.sum(2, 2));
		assertEquals(0, app.sum(1, -1));
		assertEquals(0, app.sum(0, 0));
	}
}