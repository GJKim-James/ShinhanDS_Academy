package com.shinhan.day12.exercise;

// 14장 확인문제 2번

public class ThreadExample {

	public static void main(String[] args) {
		Thread thread1 = new MovieThread();
		thread1.start();
		
		Thread thread2 = new Thread(new MusicRunnable());
		thread2.start();
	}

}
