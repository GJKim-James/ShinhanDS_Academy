package com.shinhan.day10.exercise;

// 11장 확인문제 7번
public class NotExistIDException extends Exception {
	
	public NotExistIDException() {
		
	}
	
	public NotExistIDException(String message) {
		super(message);
	}

}
