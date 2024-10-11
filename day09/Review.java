package com.shinhan.day09;

import java.awt.DisplayMode;

// modifier : public | 생략 / abstract, final(상속 불가)
abstract class Parent1 {
	// field modifier : public | protected | 생략(default) | private / final, static
	int field1 = 100;

	// constructor 추가되면 default 생성자가 자동으로 만들어지지 않는다. 자식 클래스에서 명시적으로 호출해줘야 한다.
	Parent1(String s) {

	}

	// method modifier : public | protected | 생략(default) | private / final, static
	void method1() {
		System.out.println("method1() field1 : " + field1);
	}

	// 규칙(정의)만 있고 구현은 안함 => 자식 클래스에서 구현
	abstract void work();
}

interface MyInterface1 {
	public abstract void action1();

	void action2();
}

interface MyInterface2 {
	void action3();
}

// 인터페이스는 다중 상속 가능
interface MyInterface3 extends MyInterface1, MyInterface2 {
	void action4();
}

// 구현 클래스 : 여러 개의 인터페이스 구현 가능
class Child1 extends Parent1 implements MyInterface1, MyInterface2 {
	String childField = "자식 필드";
	
	// Parent1 클래스의 Parent1(String s) 생성자 때문에 작성해줘야함.
	Child1() {
		super("");
	}

	@Override
	void method1() {
		System.out.println("method1() override field1 : " + field1);
	}

	void method1(int a) {
		System.out.println("method1() overloading field1 : " + field1);
	}

	void method2() {
		System.out.println("부모의 field 접근 : " + field1);
		method1();
	}

	// 추상 메서드 구현
	@Override
	void work() {
		System.out.println("부모 클래스에서 정의만 한 work() 추상 메서드 구현");
	}

	// MyInterface1
	@Override
	public void action1() {
		System.out.println("MyInterface1 action1()");
	}

	// MyInterface1
	@Override
	public void action2() {
		System.out.println("MyInterface2 action2()");
	}

	// MyInterface2
	@Override
	public void action3() {
		System.out.println("MyInterface2 action3()");
	}
}

public class Review {
	
	// class method
	public static void main(String[] args) {
		Child1 a = new Child1(); // 객체 생성
		
		// 자동 형 변환
		Parent1 b = a;
		MyInterface1 c = a;
		MyInterface2 d = a;
		
		// main이 static으로 선언되어 있기 때문에 Review 클래스를 메모리에 올려줘야 display() 사용 가능
		new Review().display(a);
	}
	
	// instance method
	void display(Parent1 aa) {
		// 강제 형 변환 시 반드시 instanceof로 체크해줘야 한다.
		if (aa instanceof Child1 ) {
			aa.method1();
			
			MyInterface1 bb = (MyInterface1) aa;
			bb.action1();
			bb.action2();
		}
	}

}
