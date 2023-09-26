package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {

	@GetMapping("checkIn")
	public String chekIn(Model model) {
		
		return "/work/checkIn"
	}
	
}
