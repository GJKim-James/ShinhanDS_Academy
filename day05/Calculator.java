package com.shinhan.day05;

public class Calculator {

	public int sum(int a, int b) {
		System.out.println("argument가 2개인 sum method");
		return a + b;
	}

	// 가변길이 매개변수 (배열)
	int sum(int... arr) {
		int sum = 0;

		for (int num : arr) {
			sum += num;
		}

		return sum;
	}

	String sum(int a, int b, int c) {
		System.out.println("argument가 3개인 sum method");
		return a + b + c + "";
	}

}
