package com.shinhan.day12.multithread;

import lombok.Setter;

@Setter
public class User2Thread extends Thread {
	
	Calculator calculator;
	
	User2Thread() {
		setName("User2Thread"); // Thread 이름 부여(변경)
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
}
