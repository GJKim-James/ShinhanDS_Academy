package com.shinhan.day12.exercise;

// 14장 확인문제 6번
public class MovieThread2 extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다.");
			
			if (this.isInterrupted()) {
				break;
			}
		}
	}

}
