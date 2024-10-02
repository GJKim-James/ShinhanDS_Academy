package com.shinhan.day04;

// cmd> java CarTest
// 검증
// main 시작
public class CarTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		Car car1;
		car1 = new Car();
		System.out.println("----------------------------------------");
		Car car2 = new Car("B 모델", "white", 10000); // 생성 시 field가 자동 초기화된다.
		System.out.println("----------------------------------------");
		Car car3 = new Car("C 모델");
		System.out.println("----------------------------------------");
		Car car4 = new Car("D 모델", "green");
		System.out.println("----------------------------------------");
		
		car1.model = "A 모델";
		car1.color = "black";
		car1.price = 5000;
		System.out.println(car1.model + "-" + car1.color + "-" + car1.price);
		System.out.println("----------------------------------------");
		System.out.println(car2.model + "-" + car2.color + "-" + car2.price);
		System.out.println("----------------------------------------");
		System.out.println(car3.model + "-" + car3.color + "-" + car3.price);
		System.out.println("----------------------------------------");
		System.out.println(car4.model + "-" + car4.color + "-" + car4.price);
		System.out.println("----------------------------------------");
		System.out.println(car1); // toString() 재정의한 것을 출력
	}

}
