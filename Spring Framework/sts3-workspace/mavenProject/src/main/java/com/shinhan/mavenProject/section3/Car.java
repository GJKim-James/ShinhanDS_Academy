package com.shinhan.mavenProject.section3;

import lombok.ToString;

// POJO(Plain Old Java Object) : 평범하고 오래된 자바 객체; 일반 클래스(extends나 implements 없는 클래스)
// Java Beans 문법 : field는 private modified, 기본 생성자, getter/setter
@ToString
public class Car {
	
	private String model;
	private int price;
	
	public Car() {
		System.out.println("Car Default 생성자");
	}
	
	public Car(String model, int price) {
		System.out.println("Car arg2 생성자");
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		System.out.println("Car getModel()");
		return model;
	}

	public void setModel(String model) {
		System.out.println("Car setModel()");
		this.model = model;
	}

	public int getPrice() {
		System.out.println("Car getPrice()");
		return price;
	}

	public void setPrice(int price) {
		System.out.println("Car setPrice()");
		this.price = price;
	}

}
