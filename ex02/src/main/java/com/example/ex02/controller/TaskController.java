package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
public class TaskController {
	
	@GetMapping("/loginForm")
	public String goLoginForm() {

		return "task/task01/login";
		
		
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("id") String id, String pw) {
		if(id.equals("admin")) {
			return  "task/task01/admin";
		}
		
		return "task/task01/user";
		
	}
	

}
