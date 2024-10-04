package com.shinhan.day05;

/*
 * class : 틀, template, object들을 만들기 위한 정의, object들의 공통 특성이 포함 되어있다.
 * object : class를 이용해서 만든 독립된 개체 (멤버마다 field 값이 다르다), new로 생성
 */
// JavaBeans 기술 Spec : field의 접근 지정자(Modifier) : private, 접근은 getter/setter
public class Computer {
	// 1. field(특징, 속성, 변수 : 멤버 변수, static 변수)
	String productName;
	String os;
	int price;
	
	static int count;
	
	// 2. constructor (new 시에 자동 호출되는 함수이자 메소드)
	// 이 때 자동으로 초기화(기본형 : 정수 : 0, 실수 : 0.0, boolean : false, 객체 : null)
	// 클래스 이름과 동일한 이름을 가진다. (Computer() {})
	// 정의하지 않으면 컴파일 시 자동으로 추가된다, 정의하면 컴파일 시에 자동으로 추가되지 않는다.
	// new 할 때, 초기화가 목적
	
	// 생성자를 호출하는 문장은 반드시 첫 줄만 작성 가능하다.
	Computer () {
		this(null, null, 0);
		System.out.println("Computer...default 생성자");
	}

	// Overloading : 이름이 같고, 매개변수 사양이 다르다.
	// 매개변수 이름과 field 이름이 충돌
	// 그래서 구분을 하기 위해 객체 자신을 this
	// 하나의 생성자가 같은 이름의 다른 모양의 생성자를 호출 this()
	public Computer(String productName, String os, int price) {
		count++;
		this.productName = productName;
		this.os = os;
		this.price = price;
		System.out.println("Computer 생성됨");
	}

	public Computer(String productName, String os) {
//		this.productName = productName;
//		this.os = os;
////		this.price = 50;
		this(productName, os, 50);
	}
	
	// 3. method (일반적으로 외부에서 접근하기 위해 public으로 공개)
	// 함수는 반드시 returnType을 정의해주어야 한다.
	public void printInfo() {
		System.out.println("----- Computer 정보 -----");
		System.out.println(getProductName() + " : " + productName);
		System.out.println(getOs() + " : " + os);
		System.out.println(getPrice() + " : " + price);
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setOs(String os) {
		this.os = os;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getOs() {
		return os;
	}
	
	public int getPrice() {
		return price;
	}
	
	// 4. block
	
	// 5. inner class
	
}
