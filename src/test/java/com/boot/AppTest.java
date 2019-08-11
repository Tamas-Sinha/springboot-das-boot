package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
    public void testApp() {  
		HomeController controller = new HomeController();
		String result = controller.home();
		assertEquals(result, "Das Boot, reporting for duty!" );
    }
}
