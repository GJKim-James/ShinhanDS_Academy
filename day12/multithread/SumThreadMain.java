package com.shinhan.day12.multithread;

public class SumThreadMain {

	public static void main(String[] args) {
		SumThread t1 = new SumThread(100);
		SumThread t2 = new SumThread(100000);
		
		t1.start();
		t2.start();
		
		try {
			// join() : 스레드가 끝나길 기다림
			t1.join();
//			t2.join();
			System.out.println(t1.getSum());
			System.out.println(t2.getSum());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
