package com.shinhan.day04;

// class : 틀, 설계도, template, object들의 공통 특성 정의
public class Car {

	// 1. field (변수, 멤버 변수) : 생성 시 자동 초기화
	String model;
	String color;
	int price;

	// 2. 생성자 메서드 (정의하지 않으면 컴파일러가 자동으로 만들어준다. 정의가 있으면 자동으로 만들어주지 않음.)
	// 생성자의 Overloading (생성하는 방법이 다양하다는 의미)
	// Overloading : 이름은 같고 매개변수가 다르다.
	// 값을 초기화하는 것이 목적이다.
	// 생성자가 여러 개인 경우 하나의 생성자가 다른 생성자를 호출
	Car() {
		this(null, null, 0);
		System.out.println("3. Car의 default 생성자; 매개변수 없음");
	}
	
	Car(String model, String color, int price) {
		System.out.println("========== Car가 생성됨 ==========");
		this.model = model;
		this.color = color;
		this.price = price;
	}

	Car(String model) {
		this(model, null, 0);
	}

	// 매개 변수 이름과 Field 이름이 충돌 발생
	// 구분하기 위해 현재 객체를 this 사용
	Car(String model, String color) {
//		this.model = model;
//		this.color = color;
		
		this(model, color, 0);
	}

	// toString() 재정의
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", price=" + price + "]";
	}

	// 3. 일반 메서드(기능)
	void go() {
		System.out.println("========== 직진 ==========");
	}

	void back() {
		System.out.println("========== 후진 ==========");
	}

	void stop() {
		System.out.println("========== 정지 ==========");
	}
	
	// 4. block : instance(object) block, static block
	{
		System.out.println("2. instance block : 생성 시마다 수행");
	}
	static {
		System.out.println("1. static block");
	}
	
	// 5. inner class

}
