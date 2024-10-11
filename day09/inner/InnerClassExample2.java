package com.shinhan.day09.inner;

public class InnerClassExample2 {

	InnerClassExample2(int j) {
		// 지역변수
		int i = 1;

		System.out.println("1. InnerClassExample2생성자");
		// LocalClass : 생성자함수내의 class
		class LocalClass2 {
			// 1.field
			int score = 100;

			// 2.constructor
			LocalClass2() {
				System.out.println("2. LocalClass2생성자");

			}

			// 3.method
			void f1() {
				System.out.println("f1 method");

				System.out.println(i);
			}
			
			// 4.block
			
			// 5.inner class

		}
		LocalClass2 aa = new LocalClass2();
	}

	public static void main(String[] args) {
		new InnerClassExample2(123);

	}

	public static void method1(String title) {

		// 메서드내의 class....함수내에서만 사용가능
		// 지역변수(메서드내의 변수, 매개변수 )
		// 내부class에서 지역변수가 사용되면 부조건 final (수정불가)

	}

}
