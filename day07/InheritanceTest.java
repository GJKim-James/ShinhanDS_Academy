package com.shinhan.day07;

import com.shinhan.day06.inheritance.HankookTire;
import com.shinhan.day06.inheritance.KumhoTire;
import com.shinhan.day06.inheritance.Tire;

public class InheritanceTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		Tire[] t1 = new Tire[3];
		
		t1[0] = new Tire();
		t1[1] = new HankookTire();
		t1[2] = new KumhoTire();
		
		print(t1);
	}

	private static void print(Tire[] t1) {
		// 1) 부모 = 자식
		// 2) 자식 = (자식) 부모
		for (Tire tire : t1) {
			// field는 type을 따른다.
			System.out.println("Tire 클래스의 color : " + tire.color);
			// 메서드는 Override 된 것이 수행
			tire.roll();
			
			if (tire instanceof HankookTire aa) {
//				HankookTire aa = (HankookTire) tire;
				System.out.println("HankookTire 클래스의 color : " + aa.color);
			} else if (tire instanceof KumhoTire aa) {
//				KumhoTire aa = (KumhoTire) tire;
				System.out.println("KumhoTire 클래스의 color : " + aa.color);
			}
			System.out.println("------------------------------");
		}
	}

	private static void f3() {
		Tire t1 = new Tire();
		System.out.println(t1.color);
	}

	private static void f2() {
		Child a = new Child();
		System.out.println("------------------------------");
		
		// 1. 자동 형 변환 : 부모 = 자식
		Parent var1 = new Child();
		System.out.println("------------------------------");
		// field는 타입을 따른다.(Parent의 a를 출력)
		System.out.println("var1.a : " + var1.a);
		System.out.println("------------------------------");
		// 메서드는 재정의되었다면 instance를 따른다.(Child의 method1() 실행)
		var1.method1();
		System.out.println("------------------------------");
		
		// 2. 강제 형 변환 : 자식 = (자식) 부모
		Child var2 = (Child) var1;
		System.out.println("var2.a : " + var2.a);
	}

	private static void f1() {
		Child child = new Child();
		System.out.println("------------------------------");
		
		child.method1();
		System.out.println("------------------------------");
		child.method2();
		System.out.println("------------------------------");
		
		System.out.println("child.a : " + child.a);
	}

}
