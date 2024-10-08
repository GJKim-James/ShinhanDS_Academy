package com.shinhan.day07;

public class NanoTime {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {

		long start = System.nanoTime();

		int n = 100;

		int sum = n * (n + 2) / 2;

		long end = System.nanoTime();

		System.out.println("걸린 시간 : " + (end - start) + "ns"); // 300ns
		System.out.println("1 ~ 100 합계 = " + sum);

	}

	private static void f1() {
		long start = System.nanoTime();

		int total = 0;

		for (int i = 1; i <= 100; i++) {
			total += i;
		}

		long end = System.nanoTime();

		System.out.println("걸린 시간 : " + (end - start) + "ns"); // 1500ns
		System.out.println("1 ~ 100 합계 = " + total);
	}

}
