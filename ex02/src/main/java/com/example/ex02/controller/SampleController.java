package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.LayeredHighlighter;

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
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		log.info("basic...." + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2........");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3.....only get");
	}
	
	@GetMapping("/ex01")
//	외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01...." + infoDTO.getName() + ", " + infoDTO.getAge());
	}
	
	@GetMapping("ex02")
//	외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우 @RequestParam을 사용하여 어디로 전달받을 지 알려준다.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02...." + name + ", " + age);
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas: " + datas);
		return "ex03";
	}
	
	@GetMapping("/ex04")
//	만약 매개변수가 객체라면, 해당 클래스타입의 앞글자만 소문자로 변경된 값이
//	화면에서 사용할 key값이다.
//	예) 매개변수의 타입이 InfoDTO라면, 화면에서 사용 시 key값은 infoDTO가 된다.
//	만약에 key값을 수정하거나 매개변수가 많아진다면,
//	직접 requestScope에 담아서 전달해야 한다.
//	이 때 request객체를 직접 불러오지 않고, Model이라는 데이터 전달자를 사용하게 된다.
//	하지만 화면쪽에 전달할 데이터가 여러 개가 아니라면, @ModelAttribute()를 사용하여 화면에 전달해준다.
//	@ModelAttribute("화면에서 사용할 KEY")
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("-------------------------");
		log.info("ex04........");
		log.info(infoDTO.toString());
		log.info("-------------------------");
		
		return "ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05(InfoDTO infoDTO, @ModelAttribute("gender") String gender) {
		log.info("ex05.........");
		log.info(infoDTO.toString());
		log.info("gender: " + gender);
	}
	
	@GetMapping("/ex06")
//	Model 객체는 파라미터로 request객체를 받는다.
//	따라서 여러 개의 데이터를 화면에 전달할 때
//	addAttribute(KEY, VALUE)을 사용한다.
//	화면에서는 model에 설정한 KEY로 VALUE를 사용할 수 있다.
	public String ex06(InfoDTO infoDTO, String gender, Model model) {
		log.info("ex06.........");
		log.info(infoDTO.toString());
		log.info("gender: " + gender);
		
		model.addAttribute("dto", infoDTO);
		model.addAttribute("gender", gender);
		
		return "ex/ex06";
	}
	
	@GetMapping("/ex07")
//	외부에서 학생의 번호, 국어, 영어, 수학 점수를 모델 객체로 전달받는다.
//	파라미터명과 매개변수에 선언된 모델객체의 필드명이 동일하면 자동으로 매핑된다.
//	리턴 시 알맞는 페이지로 이동이 되고, 모델 객체는 직접 KEY를 지정하지 않아도
//	화면쪽에서는 앞글자만 소문자로 바뀐 값으로 해당 필드를 접근할 수 있다.
	public String ex07(StudentVO studentVO) {
		log.info("ex07...........");
		log.info(studentVO.toString());
		return "ex/ex07";
	}
}







