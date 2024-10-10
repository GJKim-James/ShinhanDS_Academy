package com.shinhan.day08.lab2;

// 직사각형
public class Rectangle extends Shape implements Resizable {
	
	double width;
	double height;
	
	Rectangle(double width, double height) {
		super(4);
		this.width = width;
		this.height = height;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height *= s;
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height) * 2;
	}

}
