package com.shinhan.day12.multithread;

import lombok.Setter;

// 공유 객체

@Setter
public class Calculator {
	
	private int memory;
	
	synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000); // 2초간 일시 정지, 2초 후 실행 대기 상태로 갔다가 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}

}
