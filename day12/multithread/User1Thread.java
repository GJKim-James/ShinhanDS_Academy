package com.shinhan.day12.multithread;

import lombok.Setter;

@Setter
public class User1Thread extends Thread {

	Calculator calculator;

	User1Thread() {
		setName("User1Thread"); // Thread 이름 부여(변경)
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}

}
