package com.shinhan.day10;

import java.util.Scanner;

/*
 * Exception 발생 : 자동, 강제(throws)
 * 1. checked --- 일반 Exception
 * 2. unchecked --- Runtime Exception
 * 
 * Exception 처리
 * 1) 
 * 2) 
 */
public class ExceptionTest2 {

	public static void main(String[] args) throws MyException {
		f1();
	}

	private static void f1() throws MyException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID>> ");
		String id = sc.next();
		
		if (id.length() > 5) {
			// 강제로 Exception 발생하기(throw)
			throw new MyException("ID는 5자리 이하이어야 한다.");
		}
		
		sc.close();
	}

}