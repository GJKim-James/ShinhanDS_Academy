package com.shinhan.day12.multithread;

// wait()과 notify()를 이용한 스레드 제어

// 공유 객체
public class WorkObject {
	
	// synchronized 일 때만 wait(), notify()가 가능
	public synchronized void methodA() {
		System.out.println(Thread.currentThread().getName() + " methodA 작업 실행");
		
		notify(); // 일지 정지 상태에 있는 다른 스레드가 실행 대기 상태로 간다.
		
		try {
			wait(); // 나의 스레드가 일시 정지 상태로 간다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println(Thread.currentThread().getName() + " methodB 작업 실행");
		
		notify(); // 일지 정지 상태에 있는 다른 스레드가 실행 대기 상태로 간다.
		
		try {
			wait(); // 나의 스레드가 일시 정지 상태로 간다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
