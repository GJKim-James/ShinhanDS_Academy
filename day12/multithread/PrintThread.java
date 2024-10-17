package com.shinhan.day12.multithread;

// 스레드 간의 커뮤니케이션; critical section의 동기화

// 잔고 출력 Thread : 공유 영역의 lee 계좌 + sung 계좌 3번 print
public class PrintThread extends Thread {

	SharedArea sharedArea;

	PrintThread(String threadName, SharedArea sharedArea) {
		super(threadName);
		this.sharedArea = sharedArea;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			
			// 동기화 블럭 : 공유 영역을 사용 중일 때 다른 스레드가 접근 금지
//			synchronized (sharedArea) {
//				int amount = sharedArea.lee.balance + sharedArea.sung.balance;
//				System.out.println("잔고는 " + amount);
//				System.out.println("===============" + currentThread().getName() + "===============");
//			}
			sharedArea.print();
			
		}
	}

}
