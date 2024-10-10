package com.shinhan.day08;

interface Z4 {
	void f4();
}

interface Z3 {
	void f3();
}

interface Z2 extends Z3, Z4 {
	void f2();
}

interface Z {
	void f1();
}

class Student implements Z, Z2 {

	// Z2가 Z3, Z4를 상속받기 때문에 f3(), f4()도 구현해주어야 한다.
	@Override
	public void f3() {
		
	}

	@Override
	public void f4() {
		
	}

	@Override
	public void f2() {
		
	}

	@Override
	public void f1() {
		
	}
	
}

public class InterfaceTest2 {

}
