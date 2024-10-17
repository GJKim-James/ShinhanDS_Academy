package com.shinhan.day12.multithread;

//wait()과 notify()를 이용한 스레드 제어

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();
	}

}
