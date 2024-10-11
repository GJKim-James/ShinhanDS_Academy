package com.shinhan.day09.exercise;

// 9장 확인문제 4번
public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		// Tire 객체 생성
		Car.Tire tire = myCar.new Tire();
		// Engine 객체 생성(static)
		Car.Engine engine = new Car.Engine();
	}

}
