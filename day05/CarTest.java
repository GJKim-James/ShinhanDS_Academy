package com.shinhan.day05;

// cmd> java CarTest
// class load ... static은 method 영
public class CarTest {

	public static void main(String[] args) {
		
		// instance field와 method는 객체 생성 후 사용 가능
		Car car = new Car();
		Car car2 = new Car();
		System.out.println("------------------------------");
		
		System.out.println("car.gas : " + car.gas);
		System.out.println("car.speed : " + car.speed);
		System.out.println("------------------------------");
		
		car.gas = 10;
//		car.speed = 100;
		car.setSpeed(70);
		System.out.println("car.gas : " + car.gas);
//		System.out.println(car.speed);
		System.out.println("car.getSpeed() : " + car.getSpeed());
		System.out.println("------------------------------");
		
		System.out.println("Car 클래스 static 변수 사용 : " + Car.company);
		System.out.println("Car 클래스 instance 변수 사용 : " + car.company);
		System.out.println("Car 클래스 instance 변수 사용 : " + car2.company);
		Car.print();
		
	}

}
