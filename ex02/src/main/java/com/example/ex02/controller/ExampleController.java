package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
//이름을 입력, 출근 혹은 퇴근 버튼을 클릭한다.
//출근시간은 9:00, 퇴근시간은 18:00
//출근 9시 이후면 지각처리, 퇴근시간 전에 퇴근버튼 누르면 업무시간으로 처리
//모든 jsp는 work 폴더안에 분기별로getToWork, leaveWork, late,work.jsp

	@GetMapping("/checkIn")
	public String chekIn() {

		return "work/checkIn";
	}

	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute =c.get(Calendar.MINUTE);
	//	log.info("출근 들어옴");
		
		boolean lateCondition = hour >= 9 && minute >0;
		if(lateCondition) {
			return "work/late";
		}return "work/getToWork";
		
	}

	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
	//log.info("퇴근 들어옴");
		
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute =c.get(Calendar.MINUTE);
	
		
		boolean leaveWorkCondition = hour >= 18 && minute >=0;
		if(leaveWorkCondition) {
			return "work/leaveWork";
		}return "work/work";
	}
	
	// 상품의 바코드를 입력받고, 해당 상품명을 출력한다.
	// 바코드의 형태는 -> 오징어 땅콩:4383927 ...와 같이
	
	@GetMapping("/market")
	public String goMarket() {
		
		return "/market/market";
	}
	
	@PostMapping("/cashier")
	public String getProduct(String barcode,Model model) {
		String productName=null;
	
		switch(barcode) {
		case "4383927":
			productName="오징어땅콩";
			break;
		case "0832137":
			productName="초코우유";
			break;
		case "9841631":
			productName="벌꿀피자";
			break;
		case "5587578":
			productName="샌드위치";
			break;
		default :
			productName="없는 상품";
		break;
		}
		
		model.addAttribute("productName", productName);
		return "/market/cashier";
	}
	
	//선택한 할인률을 해당 상품에 적용
	//버튼을 여러개 만들어서 클릭된 할인률만큼 상품의 가격에 적용한다
	//saleChange.jsp- @Getmapping("/sale")
	
}
