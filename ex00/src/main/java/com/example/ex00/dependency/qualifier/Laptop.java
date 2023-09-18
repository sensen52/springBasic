package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("labtop") @Primary
public class Laptop implements Computer {

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1280;
	}

}
