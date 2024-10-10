package com.shinhan.day08;

public class MyInterfaceImpl2 implements MyInterface {
	
	void display() {
		System.out.println("상수 : " + COMPANY + ", " + COMPANY2);
		System.out.println("---------- default method ----------");
		print3();
		System.out.println("---------- static method ----------");
		MyInterface.print4();
	}

	@Override
	public void print1() {
		System.out.println("print1() 추상 메서드 구현");
	}

	@Override
	public void print2() {
		System.out.println("print2() 추상 메서드 구현");
	}

}
