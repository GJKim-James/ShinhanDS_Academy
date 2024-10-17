package com.shinhan.day12.multithread;

//wait()과 notify()를 이용한 스레드 제어

public class ThreadB extends Thread {

	WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		super("ThreadB");
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObject.methodB();
		}
	}

}
