package com.henriquefrezza.geekburger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeekburgerApplicationTests {

	@Test
	public void contextLoads() {
		System.setProperty("java.awt.headless", "false");
	}
}
