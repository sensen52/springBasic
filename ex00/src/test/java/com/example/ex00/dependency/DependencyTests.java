package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 이 클래스 파일은 was랑 별도로 돌아야됨 서버가 아니라 junit 프로그램을 돌리는것

@RunWith(SpringJUnit4ClassRunner.class) //어떤 프로그램을 돌릴것인가
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //xml파일 경로를 적어줌으로 써  runwith가 돌아갈때 xml을 참조해서 돌아감
@Log4j
public class DependencyTests {
	
	@Autowired
	private Coding coding; 
	
	@Test
	public void checkDependencyInjection() {
		log.info("-----------------");
		log.info("coding :"+coding);
		log.info("computer :"+coding.getComputer());
		log.info("-----------------");
	}
	
}














