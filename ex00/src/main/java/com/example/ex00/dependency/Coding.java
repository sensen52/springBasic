package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@Getter
@AllArgsConstructor
public class Coding {
	// new 키워드를 사용하면 단단한 의존 떄문에 하나만 쓸 수 있어 대신 필드주입(@Autowired) 시킨다.
	// WebApplicationContext객체가 서버가 돌아가 실행되면서 이런 어노테이션이 붙어져있는 애들을 처리
	// Coding을 사용하기 위해서 Coding의 필드를 메모리에 올리는 순간 computer도 스프링에서 자동으로 주입
	// 주의할 점은, 생성자랑은 별도로 주입되서, 순환참조(무한루프)시 오류가 발생하지 않기 때문에 StackOverFlow가 발생된다.
	
	//@Autowired
	//@NonNull
	private  final Computer computer; // 코딩이 의존하고 있는 존재
	//final :외부에서 다른값이 오지못하도록 막기(주소가 바뀌면서 오류 발생 할 수 있음)
	//원래는 final이 상수라서 필드주입만 하면 오류가 나야되는데 , data 어노테이션을 사용함으로 써 coding의 생성자 주입이 됨으로 써 사용할 수 있게 되었다
	// 결론, 생성자를 통해서 값을 받아서 그 값이 초기화에 들어갔기 때문에 오류가 안나는것 

	
   // 생성자 주입
//	@Autowired
//	public Coding(Computer computer) {
//		super();
//		this.computer = computer;
//	}
	
	
	//setter주입 
//	@Autowired
//	public void setComputer(Computer computer) {
//		this.computer = computer;
//	}
}
