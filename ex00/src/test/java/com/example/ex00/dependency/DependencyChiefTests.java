package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DependencyChiefTests {

	@Autowired
	private Restaurant restaurant;
	
	
	@Test
	public void CheifTest() {
		log.info("=====================");
		log.info("restaurant"+restaurant);
		log.info("Chief"+restaurant.getChef());
	}
	
}
