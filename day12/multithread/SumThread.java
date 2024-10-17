package com.shinhan.day12.multithread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SumThread extends Thread {
	
	private final long end;
	
//	SumThread(long end) {
//		this.end = end;
//	}
	
	private long sum;

	@Override
	public void run() {
		for (int i = 1; i <= end; i++) {
			sum += i;
		}
	}

}
