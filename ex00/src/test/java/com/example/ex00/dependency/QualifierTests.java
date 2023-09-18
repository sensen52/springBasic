package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class QualifierTests {

	@Autowired
	@Qualifier("desktop")
	private Computer desktop;
	
	
	@Autowired
	@Qualifier("labtop")
	private Computer labtop;
	

	@Autowired
	private Computer computer;

	@Test
	public void testQualifier() {
		log.info("computer" + desktop);
		log.info("screen width"+desktop.getScreenWidth());
		log.info("=====================");
		
		log.info("computer" + labtop);
		log.info("screen width"+labtop.getScreenWidth());
		log.info("=====================");
		
		log.info("computer" + computer);
		log.info("screen width"+computer.getScreenWidth());
		log.info("=====================");
	
	}

}
