package com.shinhan.day09;

// .java를 컴파일 후
// OuterClass$InnerClass.class
// OuterClass$SInnerClass.class
class OuterClass {
	// 1. field
	int score1 = 10;
	String name = "자바";
	static int s_score = 100;
	
	// 2. constructor
	
	// 3. 일반 method
	
	// 4. block
	
	// 5. inner class
	class InnerClass {
		int score2 = 20;
		boolean name = true;
		
		void method2() {
			// 변수 이름 충돌 => 내부에 있는 것이 우선
			System.out.println(score1 + score2 + OuterClass.this.name + name); // 30자바true
		}
	}
	
	// static은 객체 생성 없이 접근 가능
	// non-static은 객체 생성을 해야 접근 가능
	static class SInnerClass {
		int score3 = 30;
		static int score4 = 40;
		
		void method3() {
			System.out.println(score3 + score4 + s_score);
		}
		
		void method4() {
			System.out.println(score4 + s_score);
		}
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		// 1. instance inner class 사용법
		OuterClass.InnerClass aa = new OuterClass().new InnerClass();
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass aa2 = outer.new InnerClass();
		
		aa.method2(); // 30자바true
		
		// 2. static inner class 사용법
		
		// 1) static method
//		OuterClass.SInnerClass.method4();
		
		// 2) instance method
//		OuterClass.SInnerClass bb = new OuterClass().SInnerClass();
//		bb.method3();
	}

}
