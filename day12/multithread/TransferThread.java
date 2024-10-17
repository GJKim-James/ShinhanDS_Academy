package com.shinhan.day12.multithread;

// 스레드 간의 커뮤니케이션; critical section의 동기화

// 계좌이체 Thread : 공유 영역의 lee 계좌 -> sung 계좌로 12번 이체
public class TransferThread extends Thread {
	
	SharedArea sharedArea;
	
	public TransferThread(String threadName, SharedArea sharedArea) {
		super(threadName);
		this.sharedArea = sharedArea;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 12; i++) {
			
			// 동기화 블럭 : 공유 영역을 사용 중일 때 다른 스레드가 접근 금지
//			synchronized (sharedArea) {
//				int amount = sharedArea.lee.withdraw(100);
//				System.out.println("lee 계좌에서" + amount + "만원 출금");
//				
//				sharedArea.sung.deposit(amount);
//				System.out.println("sung 계좌에서" + amount + "만원 입금");
//				System.out.println("===============" + currentThread().getName() + "===============");
//			}
			sharedArea.transfer();
			
		}
	}

}
