package com.shinhan.day10.exercise;

// 11장 확인문제 7번
public class WrongPasswordException extends Exception {
	
	public WrongPasswordException() {
		
	}
	
	public WrongPasswordException(String message) {
		super(message);
	}

}
