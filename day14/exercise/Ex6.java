package com.shinhan.day14.exercise;

// 16장 확인문제 6번

@FunctionalInterface
interface Function2 {
	double apply(double x, double y);
}

public class Ex6 {

	public static void main(String[] args) {
		double result = calc( (x, y) -> (x / y) );
		System.out.println("result : " + result);
	}
	
	public static double calc(Function2 fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

}
