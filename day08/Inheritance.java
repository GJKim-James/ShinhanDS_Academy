package com.shinhan.day08;

/*
 * 문제. 클래스 A, B, C 는 서로 상속 관계를 가지고 있다.
 * 아래 프로그램 예시에는 각 클래스의 상속 표시가 되어있지 않아 컴파일 에러가 난다.
 * Inheritance.java 가 컴파일이 되고, 아래와 같은 출력 결과를 나타내도록 A, B, C에 상속 관계를 표시하여 프로그램을 완성하시오.
 * 
 * << 출력 결과 >>
 * a는 A의 인스턴스 이다.
 * a는 B의 인스턴스 이다.
 * a는 C의 인스턴스 이다.
 * 100  100   100  1  10   100
 * 
 * 문제 설명 :
 * 1. Inheritance.java 파일로 저장한다.
 * 2. 클래스 A, B, C 에 상속 관계를 지정하여, 컴파일 에러 없이 원하는 결과가 출력 되도록 프로그램을 수정한다.
 * 
 * 문제 힌트 및 제한 :  
 * 1. extends 키워드를 사용하여 클래스 A, B, C 간의 상속관계를 지정한다.
 */
class C extends B {
	int meth() {
		return 100;
	}

	static int sMeth() {
		return 100;
	}
}

class B extends A {
	int meth() {
		return 10;
	}

	static int sMeth() {
		return 10;
	}
}

class A {
	int meth() {
		return 1;
	}

	static int sMeth() {
		return 1;
	}
}

public class Inheritance {

	public static void main(String[] args) {
		C c = new C();
		B b = (B) c;
		A a = (A) c;

		if (a instanceof A) {
			System.out.println("a는 A의 인스턴스 이다.");
		}
		if (a instanceof B) {
			System.out.println("a는 B의 인스턴스 이다.");
		}
		if (a instanceof C) {
			System.out.println("a는 C의 인스턴스 이다.");
		}

		System.out.println(a.meth() + " " + b.meth() + " " + c.meth() + 
				A.sMeth() + " " + B.sMeth() + " " + C.sMeth());
	}

}
