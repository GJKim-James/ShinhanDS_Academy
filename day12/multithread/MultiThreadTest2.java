package com.shinhan.day12.multithread;

public class MultiThreadTest2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 스레드 시작");
		
		Account lee = new Account("123", "이몽룡", 2000);
		Account sung = new Account("1234", "성춘향", 1000);
		SharedArea sharedArea = new SharedArea(lee, sung);
		
		TransferThread thread1 = new TransferThread("이체 스레드", sharedArea);
		PrintThread thread2 = new PrintThread("출력 스레드", sharedArea);
		thread1.start();
		thread2.start();
		
		System.out.println(Thread.currentThread().getName() + " 스레드 끝");
	}

}
