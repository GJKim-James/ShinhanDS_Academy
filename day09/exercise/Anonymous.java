package com.shinhan.day09.exercise;

// 9장 확인문제 6번
public class Anonymous {
	// 익명 구현 객체를 필드 초기값으로 대입
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1() {
		// 익명 구현 객체를 로컬 변수의 초기값으로 대입
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}

}
