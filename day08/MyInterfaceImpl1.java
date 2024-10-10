package com.shinhan.day08;

// 구현 클래스 : Interface에서 정의한 규격을 따르는 클래스
// 여러 개의 Interface를 구현 가능(다중 상속과 비슷)
public class MyInterfaceImpl1 implements MyInterface {

	@Override
	public void print1() {
		System.out.println("---------- 추상 메서드 구현 ----------");
		System.out.println("----- default 메서드 사용 가능 -----");
		print3();
		// static 메서드는 Interface 소유
		MyInterface.print4();
		print4(); // MyInterface의 print4() 함수가 아닌 현재 클래스에서 새롭게 추가한 함수
	}

	@Override
	public void print3() {
		System.out.println("default 메서드 재정의(static 메서드는 재정의 불가)");
	}
	
	void print4() {
		System.out.println("재정의 아님, 함수 추가");
		System.out.println(COMPANY);
		System.out.println(COMPANY2);
	}

	@Override
	public void print2() {
		// TODO Auto-generated method stub
		
	}

}
