package com.shinhan.day12.exercise;

// 14장 확인문제 6번
public class ThreadExample2 {

	public static void main(String[] args) {
		Thread thread = new MovieThread2();
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
