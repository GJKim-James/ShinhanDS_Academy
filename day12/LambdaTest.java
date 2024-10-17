package com.shinhan.day12;

interface MyInterface1 {
	void print();
}

class MyClassImpl implements MyInterface1 {

	@Override
	public void print() {
		System.out.println("구현 클래스");
	}
	
}

public class LambdaTest {

	public static void main(String[] args) {
		// 1. 구현 클래스

		// 2. 익명 구현 클래스

		// 3. 람다 표현식
		MyInterface1 a2 = () -> {
			System.out.println("람다표현식");
		};

		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 구현 클래스");
			}
		};

		Thread t1 = new Thread(r);
		t1.start();
		
		Runnable r2 = () -> {
			System.out.println("람다식 익명 구현 클래스");
		};
		
		Thread t2 = new Thread(r2);
		t2.start();
		
		System.out.println("========== Main END ==========");
		
//		a2.print();
	}

}
