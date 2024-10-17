package com.shinhan.day12.multithread;

public class WorkThread extends Thread {
	boolean work = true;
	
	WorkThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName() + " 작업 처리");
			} else {
				Thread.yield(); // 양보
			}
		}
	}

}
