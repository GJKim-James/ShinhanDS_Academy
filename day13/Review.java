package com.shinhan.day13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.shinhan.day12.multithread.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Thread : 하나의 프로세스 내의 프로그램의 흐름, run() 구현
// 1) java.lang.Thread 상속
class MyThread extends Thread {
	MyThread() {
		super("AA");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " MyThread 구현");
	}
}

// 2) Runnable 인터페이스 구현 후 Thread 만든다.
// new Thread(new MyRunnable())
class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRunnable 구현");
	}
}

// Generic
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Product<T, A> {
	T model;
	A size;
}

class ChildProduct<T, A, B> extends Product<T, A> {
	B color;

	ChildProduct(T model, A size, B color) {
		super(model, size);
		this.color = color;
	}
}

@ToString
@AllArgsConstructor
class Goods<T> {
	T aa;
}

class Shopping {
	static <T, A> Product<T, A> makeProduct(T model, A size) {
		return new Product<>(model, size);
	}

	static <T, A, B> ChildProduct<T, A, B> makeChildProduct(T model, A size, B color) {
		return new ChildProduct<T, A, B>(model, size, color);
	}

	static void f1(Goods<?> g) {
		System.out.println("f1");
		System.out.println(g);
	}

	static <T, A> void f2(Goods<? extends Product<T, A>> g) {
		System.out.println("f2");
		System.out.println(g);
	}
	
	static <T, A, B> void f3(Goods<? super ChildProduct<T, A, B>> g) {
		System.out.println("f3");
		System.out.println(g);
	}
}

public class Review {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
		System.out.println("========== " + Thread.currentThread().getName() + " END ==========");
	}

	private static void f5() {
		Goods<String> g1 = new Goods<>("!!!!!");
		Shopping.f1(g1);
		
		Product<String, Integer> p1 = Shopping.makeProduct("ABC 모델", 1000);		
		Goods<Product<String, Integer>> g2 = new Goods<>(p1);
		Shopping.f2(g2);
		Shopping.f3(g2);
				
		ChildProduct<String, String, String> p3 = Shopping.makeChildProduct("AA", "big", "red");
		Goods<ChildProduct<String, String, String>> g3 = new Goods<>(p3);
		Shopping.f2(g3);
		Shopping.f3(g3);
	}

	private static void f4() {
		Product<String, Integer> p1 = Shopping.makeProduct("ABC 모델", 1000);
		Product<Integer, Account> p2 = Shopping.makeProduct(1000, new Account("A", "B", 100));

		ChildProduct<String, String, String> p3 = Shopping.makeChildProduct("AA", "big", "red");
	}

	private static void f3() {
		Product<String, Integer> p = new Product<>("TV", 1000);
		Product<Integer, Account> p2 = new Product<>(2000, new Account("A", "B", 100));

		System.out.println(p);
		System.out.println(p2);
	}

	private static void f2() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
	}

	private static void f1() {
		int a = 10;
		a++;
		int score = a;

		MyThread t1 = new MyThread();

		// MyThread는 Thread를 상속받았기 때문에 Thread 타입으로 선언 가능
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 구현 클래스, " + score);
			}
		});
		Thread t4 = new Thread(() -> {
			System.out.println("람다표현식으로 구현");
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
