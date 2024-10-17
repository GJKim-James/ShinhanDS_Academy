package com.shinhan.day12.multithread;

// 1) thread 만들기, Thread 상속 받기
public class AlphabetUpperCaseThread extends Thread {

	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(Thread.currentThread().getName() + " : " + ch);
		}
		System.out.println("----------------------------------------");
	}

}
