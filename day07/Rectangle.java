package com.shinhan.day07;

public class Rectangle extends Shape {
	
	int length;
	int width;

	public Rectangle(String color, int length, int width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}

	@Override
	public double calculateArea() {
		return length * width;
	}

	@Override
	public double calculatePerimeter() {
		return (length + width) * 2;
	}

}
