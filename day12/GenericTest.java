package com.shinhan.day12;

public class GenericTest {

	public static void main(String[] args) {
		// 제네릭 메소드
		Box<String> a = makeBox("문자");
		Box<Integer> b = makeBox(100);
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		// 제한된 타입 파라미터
		boolean result = compare(10.5, 20.5);
		System.out.println("result : " + result);
	}

	// 제한된 타입 파라미터
	private static <T extends Number> boolean compare(T data1, T data2) {
		double a = data1.doubleValue();
		double b = data2.doubleValue();
		
		return a == b;
	}

	// 제네릭 메소드
	private static <T> Box<T> makeBox(T data) {
		return new Box<>(data);
	}

}
