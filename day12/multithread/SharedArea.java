package com.shinhan.day12.multithread;

import lombok.AllArgsConstructor;

// 스레드 간의 커뮤니케이션; critical section의 동기화

@AllArgsConstructor
public class SharedArea {
	Account lee; // 이몽룡 계좌
	Account sung; // 성춘향 계좌
	
	// synchronized(동기화) : 공유 영역을 사용 중일 때 다른 스레드가 접근 불가
	synchronized void transfer() {
		int amount = lee.withdraw(100);
		System.out.println("lee 계좌에서" + amount + "만원 출금");
		
		sung.deposit(amount);
		System.out.println("sung 계좌에서" + amount + "만원 입금");
		System.out.println("========== " + Thread.currentThread().getName() + " ==========");
	}
	
	synchronized void print() {
		int amount = lee.balance + sung.balance;
		System.out.println("잔고는 " + amount);
		System.out.println("========== " + Thread.currentThread().getName() + " ==========");
	}
}
