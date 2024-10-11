package com.shinhan.day09;

abstract class Tire {
	public abstract void roll();
}

class KumhoTire extends Tire {
	public void roll() {
		System.out.println("금호타이어가 굴러갑니다.(재정의)");
	}
}

class Car {
	// 추상 클래스는 인스턴스 생성 불가
//	Tire tire1 = new Tire();
	
	Tire tire2 = new KumhoTire();
	
	// 필요할 때 바로 사용하고 버림 => 익명 구현 클래스 만들어서 사용
	Tire tire3 = new Tire() {
		public void roll() {
			System.out.println("AA타이어가 굴러갑니다.");
		}
	};
	
	void method() {
		Tire tire4 = new KumhoTire();
		Tire tire5 = new Tire() {
			public void roll() {
				System.out.println("BB타이어가 굴러갑니다.");
			}
		};
		call(tire2);
		call(tire3);
		call(tire4);
		call(tire5);
	}

	private void call(Tire t) {
		t.roll();
	}
}

// 익명 구현 클래스 연습
public class AnonymousClass {

	public static void main(String[] args) {
		Car car = new Car();
		car.method();
	}

}
