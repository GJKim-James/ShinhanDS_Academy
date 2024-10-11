package com.shinhan.day09;

class Window {
	// field
	String subject = "자바";
	
	// 1. instance inner class
	class InnerClass {

	}

	// 2. static inner class
	static class InnerClass2 {

	}

	void method(String param) {
		// 3. Local Class
		String localVar = "지역변수";
		class LocalClass {
			// local class에서 지역변수에 접근하면 Modifier는 final이다.
			void call() {
//				localVar = "수정"; // 수정 불가
				System.out.println("field : " + subject);
				System.out.println("매개변수 : " + param);
				System.out.println("지역변수 : " + localVar);
			}
		}

		class LocalClass2 {

		}
		LocalClass aa = new LocalClass();
		aa.call();
	}
	
	// 4. interface
	static interface MyInterface {
		
	}
}

public class InnerClassTest2 {
	
	public static void main(String[] args) {
		// 1. instance inner class
		Window.InnerClass aa = new Window().new InnerClass();
		
		// 2. static inner class
		Window.InnerClass2 bb = new Window.InnerClass2();
		
		// 익명 구현 클래스 만들고 실행
		(new Window.MyInterface() {
			void method1() {
				System.out.println("익명 구현 클래스 Override");
			}
		}).method1();
	}

}
