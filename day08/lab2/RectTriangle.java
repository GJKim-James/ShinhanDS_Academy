package com.shinhan.day08.lab2;

// 직각삼각형
public class RectTriangle extends Shape {
	
	double width;
	double height;

	RectTriangle(double width, double height) {
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		return width * height / 2;
	}

	@Override
	double getPerimeter() {
		// 빗변 = Math.sqrt(width * width + height * height), Math.sqrt() : 루트
		double hypotenuse = Math.sqrt((width * width + height * height));
		
		return width + height + hypotenuse;
	}
	
}
