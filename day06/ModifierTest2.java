package com.shinhan.day06;

import com.shinhan.day05.Phone;

public class ModifierTest2 extends Phone {

	public static void main(String[] args) {
		// static final
		System.out.println(Integer.MAX_VALUE);
		// static method
		System.out.println(Integer.bitCount(7)); // bitCount() : 1의 개수 출력
		System.out.println("------------------------------");

		// instance method
		Integer a = 10;
		Integer b = 11;
		System.out.println(a.compareTo(b)); // 같으면 0, a > b이면 1, a < b이면 -1 출력
		System.out.println("------------------------------");
		
		
		String s1 = "자바";
		String s2 = new String("자바");
		byte[] bytes = { 65, 66, 67 };
		String s3 = new String(bytes);
		System.out.println("s3 : " + s3);

	}

	void test() {
		Phone p1 = new Phone();

		System.out.println(a + b);
		print1();
		print2();
	}

}
