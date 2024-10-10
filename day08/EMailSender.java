package com.shinhan.day08;

public class EMailSender extends MessageSender {
	
	String senderAddr;
	String emailBody;
	
	EMailSender(String title, String senderName, String senderAddr, String emailBody) {
//		super(); // 자동은 부모의 default 생성자 호출
		super(title, senderName); // 명시적으로 부모의 생성자 호출
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	
	// 이름, 매개변수, return 같고, modifier는 같거나 더 넓어져야 한다.
	// public > protected > 생략(default) > private
	@Override
	void sendMessage(String recipient) {
		System.out.println("----------------------------------------");
		System.out.println("제목 : " + title);
		System.out.println("보내는 사람 : " + senderName + " " + senderAddr);
		System.out.println("받는 사람 : " + recipient);
		System.out.println("내용 : " + emailBody);
	}
	
}
