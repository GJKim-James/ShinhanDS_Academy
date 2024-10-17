package com.shinhan.day12.multithread;

public class BathRoom {
	
	boolean isFirst = true;
	
	public synchronized void use(String name) {
		if (isFirst && name.equals("김")) {
			try {
				wait(); // 꺠워줄 때까지 기다린다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "님이 입장");
		System.out.println(name + "님이 사용");
		System.out.println(name + "님이 퇴장");
		System.out.println("--------------------");
		
		isFirst = false;
		
		notifyAll(); // wait() 상태 깨우기
	}

}
