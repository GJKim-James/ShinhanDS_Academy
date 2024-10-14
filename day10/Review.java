package com.shinhan.day10;

class Parent {

}

interface MyInterface {
	// 상수 + 추상 메소드 + default 메소드 + static 메소드 + private 메소드
}

// 부모의 field, method를 상속 받아서 private 제외하고 모두 사용 가능
// 수정 가능(final 제외하고 Override 가능)
// 추가 가능(만약, 이름 같고 매개변수 다르고 return 같음; Overloading)
class Child extends Parent implements MyInterface, Comparable<Child> {
	
	// 1. field
	int a = 1;
	static int b = 2;
	
	// 2. constructor
	
	// 3. method
	void method1() {
		
	}
	
	static void method2() {
		
	}
	
	// 4. block

	// 5. inner class
	// 1) instance inner class
	class InnerClass {
		void func() {
			System.out.println(a + b);
			method1();
			method2();
		}
	}

	// 2) static inner class
	static class StaticInnerClass {
		String name = "자바";
		static int price = 20000;
		
		void func() {
//			System.out.println(a); // 불가(static이 아니라 인스턴스 변수이기 때문)
			System.out.println(b);
//			method1(); // 불가(static이 아니라 인스턴스 메소드이기 때문)
			method2();
		}
	}
	
	// 3) Local inner class
	void call(int param) {
		// 지역변수
		int score = 100;
//		socre = 200; // 불가
		
		class LocalInnerClass {
			void method1() {
				// 외부의 지역변수가 LocalInnerClass에서 사용되면 Modifier가 final이 된다.
				// 변경하고 싶다면 다른 변수에 옮겨 닮은 후 변경
				int score2 = score;
				score2++;
				System.out.println("score : " + score);
				System.out.println("score2 : " + score2);
				System.out.println("param : " + param);
			}
		}
		
	}
	
	@Override
	public int compareTo(Child o) {
		return 0;
	}

}

public class Review {

	public static void main(String[] args) {
		
	}

}
