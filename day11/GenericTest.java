package com.shinhan.day11;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
		Box_Generic<String, String> result = boxing("AA", "BB");
		Box_Generic<String, Integer> result2 = boxing("AA", 100);
		Box_Generic<Integer, Integer> result3 = boxing(1, 100);
		
		System.out.println("result : " + result);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}
	
	public static <T, A> Box_Generic<T, A> boxing(T content, A size) {
		Box_Generic<T, A> aa = new Box_Generic<>(content, size);
		return aa;
	}

	private static void method3() {
		ArrayList<String> aList = new ArrayList<>();
		
		aList.add("java1");
		aList.add("java2");
		aList.add("java3");
		aList.add("java4");
		
		for (String s : aList) {
			System.out.println(s);
		}
	}

	private static void method2() {
		Product<String, String> product1 = new Product<>();

		CellPhone phone = new CellPhone("ABC");
		Product<CellPhone, String> product2 = new Product<>(phone, "A", "large", 100);
		System.out.println(product2);
	}

	private static void method1() {
		Box_Generic<String, String> box1 = new Box_Generic<>();
		box1.content = "문자";
		box1.size = "large";

		Box_Generic<String, String> box2 = new Box_Generic<>("커피", "A");

		Box_Generic<String, Integer> box3 = new Box_Generic<>("커피", 100);
	}

}
