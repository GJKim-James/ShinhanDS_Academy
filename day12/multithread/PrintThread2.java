package com.shinhan.day12.multithread;

public class PrintThread2 extends Thread {
	
	boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		// 방법 1)
//		while (!stop) {
//			System.out.println("실행 중" + stop);
//		}
		
		// 방법 2)
		try {
			while (true) {
				System.out.println("실행중이다.");
				sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("자원 정리~" + stop);
		System.out.println("안전하게 thread 종료");
	}

}
