package com.shinhan.day05;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		cal.sum();
		
		int result = cal.sum(1, 2);
		System.out.println("result : " + result);
		System.out.println("----------------------------------------");
		
		String result2 = cal.sum(1, 2, 3);
		System.out.println(result2 + 4);
		System.out.println("----------------------------------------");
		
		int result3 = cal.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(result3);
		System.out.println("----------------------------------------");
		
		result3 = cal.sum(new int[] {10, 20});
		System.out.println(result3);
		
	}

}
