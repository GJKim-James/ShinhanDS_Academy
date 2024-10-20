package com.shinhan.day13;

// 람다표현식이 가능한가?를 컴파일 시에 체크하는 Annotation
// 람다표현식은 인터페이스가 하나의 추상 메소드만 가지고 있는 경우
@FunctionalInterface
interface MyInterface {
	void method1();
}

// 1. 구현 클래스 만들어서 사용하기
class MyClassImpl implements MyInterface {
	@Override
	public void method1() {
		System.out.println("1. 구현 클래스 만들어서 사용하기");
	}
}

public class LambdaTest {

	public static void main(String[] args) {
		work(new MyClassImpl());
		
		// 2. 익명 구현 클래스 사용하기
		work(new MyInterface() {
			@Override
			public void method1() {
				System.out.println("2. 익명 구현 클래스 사용하기");
			}
		});
		
		work(() -> System.out.println("3. 람다표현식"));
		
		work(() -> {
			System.out.println("4. 람다표현식");
			System.out.println("4. 람다표현식");
		});
	}
	
	private static void work(MyInterface myClassImpl) {
		myClassImpl.method1();
	}

}
