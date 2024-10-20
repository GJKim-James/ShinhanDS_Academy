package com.shinhan.day13.lambda_args;

public class Person {
	public void action(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}
	
	public void action2(Speakable speakable) {
		speakable.speak("안녕하세요");
	}
}
