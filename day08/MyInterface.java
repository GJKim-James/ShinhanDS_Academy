package com.shinhan.day08;

// 규칙들이 들어있는 규격서
// 상수 + 추상 메서드들의 묶음
// 생성자 없음
// Collection 인터페이스 - List(ArrayList, LinkedList, Vector), Set(HashSet, TreeSet), Map
public interface MyInterface {
	
	// 1. 상수 : static final 생략 가능
	static final String COMPANY = "신한DS";
	String COMPANY2 = "신한은행";
	
	// 2. 추상 메서드 : public abstract 생략 가능
	public abstract void print1();
	void print2();
	// 일반 메서드는 불가
//	void print3() {
//		
//	}
	
	// 3. default 메서드
	default void print3() {
		System.out.println("구현 클래스에서 공통적으로 사용할 기능(재정의 가능)");
		print5();
	}
	
	// 4. Interface의 method; 사용법 => MyInterface.print5()
	// static 메서드(재정의 불가)
	static void print4() {
		System.out.println("구현 클래스에서 공통적으로 사용할 기능(재정의 불가능)");
		print6();
	}
	
	// 5. private method : Interface 내에서만 사용 가능
	// default 메서드에서 사용
	private void print5() {
		System.out.println("Interface 안에서만 사용 가능");
	}
	
	// static 메서드에서 사용
	private static void print6() {
		System.out.println("Interface 안에서만 사용 가능");
	}

}
