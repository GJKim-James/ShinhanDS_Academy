package com.shinhan.day09.exercise;

// 9장 확인문제 6번
public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		anony.field.run();
		anony.method1();
		// 익명 구현 객체를 메소드의 매개값으로 대입
		anony.method2(new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}

}
