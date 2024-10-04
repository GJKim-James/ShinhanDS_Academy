package com.shinhan.day05;

// final : 최종, 변경 불가
// 세 군데에서 사용할 수 있다.
// 1. field에 사용하면 값 변경 불가
// 2. method에 사용하면 재정의 불가
// 3. class에 사용하면 상속 불가
public class Phone {
	
	public String model;
	public int price;
	
	// 값을 할당 후 수정 불가 : instance 변수이므로 선언 시, 생성 시
	public final String company = "aa";
	public final String company2;
	public Phone() {
		company2 = "bb";
	}
	public Phone(String s) {
		company2 = s;
	}
	// 선언 시 초기화 필수(상수), 관례상 이름은 대문자로 사용
	// final static, static final 둘 다 가능
	public final static String COMPANY3 = "cc";
	
	// 접근 제한자
	// public : 모든 패키지에서 접근 가능
	public int a =10;
	// protected : 같은 패키지에서는 접근 가능, 다른 패키지이면 상속받아야 접근 가능
	protected int b = 20;
	// default, modifier 생략 : 같은 패키지에서만 접근 가능
	int c = 30;
	// private : 클래스 내부에서만 접근 가능
	private int d = 40;
	
	void test() {
		System.out.println("d : " + d);
		print1();
		print2();
		print3();
		print4();
	}
	
	public void print1() {
		System.out.println("Phone class의 public method");
	}
	
	protected void print2() {
		System.out.println("Phone class의 protected method");
	}
	
	void print3() {
		System.out.println("Phone class의 default method");
	}
	
	private void print4() {
		System.out.println("Phone class의 private method");
	}

}
