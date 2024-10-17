package com.shinhan.day12.multithread;

public class WorkThreadMain {

	public static void main(String[] args) {
		WorkThread t1 = new WorkThread("A 스레드");
		WorkThread t2 = new WorkThread("B 스레드");
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = true;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = true;
	}

}
