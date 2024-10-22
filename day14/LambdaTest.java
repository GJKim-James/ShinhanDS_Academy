package com.shinhan.day14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface MyConsumer<T> {
	public void accept(T t);
}

@FunctionalInterface
interface MySupplier<T> {
	public T get();
}

public class LambdaTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() {
		BiFunction<Person, String, Double> f = (a, b) -> {
			System.out.println(b);
			return (a.getAge() + a.getAge()) / 2.0;	
		};
		Person p = new Person("Kim", 28);
		double result = f.apply(p, "***");
		System.out.println("result : " + result);
	}

	private static void f4() {
		Function<Person, String> f = (p) -> p.getName();
		Function<Person, Integer> f2 = (p) -> p.getAge();
		Person p = new Person("Kim", 28);
		String result = f.apply(p);
		System.out.println("name : " + result);
		int result2 = f2.apply(p);
		System.out.println("age : " + result2);
	}

	private static void f3() {
		MySupplier<Integer> a = () -> {
			Person p = new Person("Kim", 30);
			return p.getAge();
		};
		
		Supplier<Integer> b = () -> {
			Person p = new Person("Kim", 30);
			return p.getAge();
		};
		
		int result = b.get();
		System.out.println("Supplier<Integer> b에서 받은 나이 : " + result);
		
		Supplier<String> c = () -> {
			Person p = new Person("Kim", 30);
			return p.getName();
		};
		
		String result2 = c.get();
		System.out.println("Supplier<Integer> c에서 받은 이름 : " + result2);
	}

	private static void f2() {
		// 정의, 익명 구현 클래스, 람다표현식
		BiConsumer<String, Person> consumer = (s, p) -> {
			System.out.println(s);
			System.out.println("이름 : " + p.getName());
			System.out.println("나이 : " + p.getAge());
		};
		// 사용
		consumer.accept("문자", new Person("김광진", 28));
	}

	private static void f1() {
		// 구현 클래스
		MyConsumer<Integer> a = new MyConsumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t / 10);
			}
		};
		a.accept(100);

		// 람다표현식
		MyConsumer<String> a2 = (t) -> System.out.println(t + "***");
		a2.accept("200");
		
		Consumer<String> a3 = (t) -> System.out.println(t + "!!!");
		a3.accept("문자");
		
		Consumer<Person> a4 = (t) -> System.out.println(t + "###");
		a4.accept(new Person("홍길동", 20));
	}

}
