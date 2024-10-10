package com.shinhan.day08.lab2;

/*
 * 1. 각 클래스 및 인터페이스를 작성하십시오
 *   A. Shape 추상 클래스를 작성하십시오.
 *   B. getArea 메쏘드와 getPerimeter 메쏘드의 리턴 타입은 double 형입니다.
 *   C. RectTriangle(직각삼각형) 클래스를 작성하십시오.
 *      직각삼각형의 둘레를 구하기 위해 피타고라스의 정리를 사용할 때 Math 클래스를 이용할 수 있습니다.
 *   D. Rectangle(직사각형) 클래스를 작성하십시오.
 *   E. Resizable 인터페이스를 작성하고, Rectangle 클래스가 implement 하도록 하십시오.
 *      resize 메쏘드는 double type의 argument 하나를 받아서, 기존 width와 height를 해당 인자를 곱한 값으로 변경합니다.
 *      (예: width = width * s;)
 * 
 * 2. ShapeTest 클래스를 작성하여 위에서 작성한 클래스를 테스트 하십시오.
 *   F. 밑변이 5, 높이가 6인 Rectangle Object를 하나 생성합니다.
 *   G. 밑변이 6, 높이가 2인 RectTriangle Object를 하나 생성합니다.
 *   H. 위의 2가지 Object를 배열에 추가합니다.
 *   I. 순환문을 사용해서 배열에 들어 있는 각 Shape들의 area와 perimeter를 출력합니다.
 *      만일 해당 Shpae가 Resizable 하다면, 0.5 만큼 resize한 후 새로운 area와 perimeter를 출력합니다. (new area / new perimeter)
 *  
 *  
 * 화면 출력(ShpeTest 실행):
 * area: 30.0
 * perimeter: 22.0
 * new area: 7.5
 * new perimeter: 11.0
 * area: 6.0
 * perimeter: 14.32455532033676
 *  
 * 주의 사항 :
 * １) 별도로 제시되는 소스 파일이 없습니다.
 * ２) 이번 문제에서 작성해야할 소스 파일은 총 5개입니다.
 *    (Shape.java, Resizable.java, Rectangle.java, RectTriangle.java, ShapeTest.java)
 * ３) 테스트 목적으로 스스로 main을 구현할 수 있습니다. main의 내용은 채점하지 않습니다.
 */
public abstract class Shape {
	
	// 1. field
	int numSides; // 변의 수
	
	// 2. 생성자
	Shape(int numSides) {
		this.numSides = numSides;
	}
	
	// 3. 일반 메서드
	int getNumSides() {
		return numSides;
	}
	
	abstract double getArea(); // 넓이
	
	abstract double getPerimeter(); // 둘레 길이

}
