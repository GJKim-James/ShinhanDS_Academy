package com.shinhan.day10;

// 예외로 사용하고자 한다.
// extends Exception 을 상속받았으므로 일반 예외이다.
public class MyException extends Exception {
	String message2;
	
	public MyException(String message) {
		super(message);
		this.message2 = message;
	}
	
	void f1() {
		System.out.println(message2 + "..........");
	}

}
