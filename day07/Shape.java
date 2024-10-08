package com.shinhan.day07;

// abstract class : 추상 메서드가 하나 이상 존재하는 클래스
// 추상 메서드 : 함수의 정의는 있으나 구현은 없는 함수
public abstract class Shape {

	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	// 부모의 메서드는 있지만 field 값을 가지고 있지 않아서 구현 불가
	// 부모는 정의만 하고 자식이 구현하도록 한다.
	// 부모를 통해 자식의 기능을 수행하기 위해 존재
	public abstract double calculateArea(); // 면적

	public abstract double calculatePerimeter(); // 둘레

	public String toString() {
		return color + " " + type;
	}

}
