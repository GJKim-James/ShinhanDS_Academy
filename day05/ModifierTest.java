package com.shinhan.day05;

public class ModifierTest {
	
	void test() {
		Phone p1 = new Phone();
		
		System.out.println(p1.a);
		System.out.println(p1.b);
		System.out.println(p1.c);
//		System.out.println(p1.d); // private으로 선언했기 때문에 접근 불가
		
		p1.print1();
		p1.print2();
		p1.print3();
//		p1.print4(); // // private으로 선언했기 때문에 접근 불가
	}

}
