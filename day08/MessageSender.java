package com.shinhan.day08;

// abstract class : 클래스 내에 abstract 메서드가 0개 이상 존재한다.(없을 수도 있다.)
public abstract class MessageSender {
	// 1. field
	String title;
	String senderName;
	
	// 2. constructor
	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	
	// 3. method
	// 추상 메서드 선언 : 정의만 있고 구현은 없다. 구현은 자식 클래스에서 한다.
	abstract void sendMessage(String recipient);

}
