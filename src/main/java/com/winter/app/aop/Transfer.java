package com.winter.app.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public int subway(String str) {
		System.out.println("지하철");
		return 100;
	}
	public String bus(int num, String name) {
		System.out.println("bus");
		return "bus";
	}
	public void taxi() {
		System.out.println("택시");				
	}
}
