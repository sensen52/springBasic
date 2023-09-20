package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;
import com.example.ex02.domain.vo.StudentVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*")
@Log4j
public class SampleController {

	@RequestMapping(value ="/basic",method = {RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		
		log.info("basic····"+req.getMethod());
		}
	
	@RequestMapping //경로를 안정해주면 부모 requestMapping이 디폴트 값
	public void basic2() {
		log.info("basic2");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3 only get");
	}
	
	//외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	@GetMapping("/ex01")
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01"+infoDTO.getName()+","+infoDTO.getAge());
	}
	
	//외부에서 전달된 파라미터의 이름과 매개변수가 다를경우 @RequestParam을 통해 어디로 전달받을지 알려준다.
	@GetMapping("/ex02")
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2")int age) {
		log.info("ex02"+name+","+age);
	}
	
	//파라미터를 arrayList 사용
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		
		log.info("datas:"+datas);
		
		return "ex03";
		
	}
	
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("======================");
		log.info("Ex04........");
		log.info(infoDTO.toString());
		log.info("======================");
		
		return "ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05(InfoDTO infoDTO,@ModelAttribute("gender") String gender) {
		
		log.info("Ex05.......");
		log.info(infoDTO.toString());
		log.info("gender"+gender);
	}
	//모델 객체는 파라미터로 request 객체를 받는다
	//따라서 여러개의 데이터를 화면에 전달할때 
	//addAttribute(key,value)를 사용한다.
	//화면에서는 model에 설정한 key로 value를 사용할 수 있다.
	
	@GetMapping("/ex06")
	public String ex06(InfoDTO infoDTO,String gender, Model model) {
		log.info("Ex06.......");
		log.info(infoDTO.toString());
		log.info("gender"+gender);
		
		model.addAttribute("dto",infoDTO);
		model.addAttribute("gender", gender);
		
		return "ex/ex06";
	}
	
	@GetMapping("/ex07")
	public String ex07(StudentVO studentVO) {
		log.info("ex07...");
		log.info(studentVO.toString());
		
		return "ex/ex07";
	}

}
