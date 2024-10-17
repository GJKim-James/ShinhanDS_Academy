package com.shinhan.day12.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Runnable : 작업 처리 완료 후 리턴값이 없을 때 사용
public class RunnableExecuteExample {
	
	public static void main(String[] args) {
		// 1000개의 메일 생성
		String[][] mails = new String[1000][3];
		
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}
		
		// ExecutorService 생성(5개 스레드로 1000개 메일 수신)
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		// 이메일을 보내는 작업 생성 및 처리 요청
		for (int i = 0; i < 1000; i++) {
//			final int idx = i;
//			
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					Thread thread = Thread.currentThread();
//					
//					String from = mails[idx][0];
//					String to = mails[idx][1];
//					String content = mails[idx][2];
//					
//					System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + " : " + content);
//				}
//			});
			
			// 람다식 이용
			int j = i;
			
			executorService.execute(() -> {
				String s = "[" + Thread.currentThread().getName() + "] 보낸 사람 : " + mails[j][0]
						+ ", 받는 사람 : " + mails[j][1] + ", 내용 : " + mails[j][2];
				System.out.println(s);
			});
		}
		
		// ExecutorService 종료
		executorService.shutdown();
	}

}
