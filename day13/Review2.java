package com.shinhan.day13;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
class Box<K, S> {
	K kind;
	S size;
}

@ToString(callSuper = true)
@NoArgsConstructor
class ChildBox<K, S, P> extends Box<K, S> {
	P price;
	
	// @AllArgsConstructor을 코드로 생성한 것
	ChildBox(K kind, S size, P price) {
		super(kind, size);
		this.price = price;
	}
}

@ToString
@AllArgsConstructor
class Delivery<T> {
	T goods;
}

class Coupang {
	static <K, S> Box<K, S> makeBox(K kind, S size) {
		return new Box<K, S>(kind, size);
	}
	
	static <K, S, P> ChildBox<K, S, P> makeChildBox(K kind, S size, P price) {
		return new ChildBox<>(kind, size, price);
	}
	
	void f1(Delivery<?> d) {
		System.out.println(d);
	}
	
	void f2(Delivery<? extends Number> d) {
		System.out.println(d);
	}
	
	<K, S> void f3(Delivery<? extends Box<K, S>> d) {
		System.out.println(d);
	}
	
	<K, S> void f4(Delivery<? super Box<K, S>> d) {
		System.out.println(d);
	}
	
	<K, S, P> void f5(Delivery<? super ChildBox<K, S, P>> d) {
		System.out.println(d);
	}
}

public class Review2 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		Coupang coupang = new Coupang();
		
		Delivery<String> d1 = new Delivery<>("A");
		coupang.f1(d1);
		
		Delivery<Integer> d2 = new Delivery<>(100);
		coupang.f2(d2);
		
		Delivery<Box<String, Integer>> d3 = new Delivery<>(new Box<>("B", 100));
		coupang.f3(d3);
		
		coupang.f4(d3);
		
		Delivery<Box<String, Integer>> d5 = new Delivery<>(new Box<>("B", 100));
		coupang.f5(d5);
		
		Delivery<ChildBox<String, Integer, Integer>> d6 = new Delivery<>(new ChildBox<>("B", 100, 200));
		coupang.f5(d6);
		
		Delivery<Object> d7 = new Delivery<>(new Object());
		coupang.f5(d7);
	}

	private static void f3() {
		Box<String, String> b1 = Coupang.makeBox("스마트폰", "big");
		System.out.println(b1);
		
		ChildBox<String, Integer, Integer> b2 = Coupang.makeChildBox("TV", 1, 300);
		System.out.println(b2);
	}

	private static void f2() {
		ChildBox<String, Integer, Integer> b1 = new ChildBox<>("TV", 100, 200);
		System.out.println(b1);
	}
	
	private static void f1() {
		Box<String, String> box1 = new Box<>();
		System.out.println(box1);
		
		Box<String, String> box2 = new Box<>("A", "B");
		System.out.println(box2);
	}

}
