package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Component
@Getter
@AllArgsConstructor
public class Restaurant {

	
	@Autowired
	private final Chef Chef;
	
}
