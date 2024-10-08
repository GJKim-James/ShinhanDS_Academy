package com.shinhan.day07;

public class Circle extends Shape {
	
	double radius;
	double circumference;

	public Circle(String color, int radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double calculatePerimeter() {
		circumference = 2 * Math.PI * radius;
		return circumference;
	}

	public double getRadius() {
		return radius;
	}

}
