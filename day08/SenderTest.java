package com.shinhan.day08;

public class SenderTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		// 추상 클래스는 instance화 불가
		// MessageSender a = new MessageSender("", "", "", "");
		
		// title, senderName, senderAddr, emailBody
		EMailSender sender1 = new EMailSender("한글날", "신한DS 금융 SW 아카데미", "shinhanDS@naver.com", "휴강");
		
		// title, senderName, returnPhoneNo, message
		SMSSender sender2 = new SMSSender("화요일", "신한DS 금융 SW 아카데미", "010-1234-5678", "휴강 안내");
		
		send(sender1, "gjk0635@naver.com");
		send(sender2, "010-6426-1967");
	}

	// 다형성 = 자동 형 변환 + Override
	// 사용법은 같고 결과는 다르다.
	private static void send(MessageSender sender, String recipient) {
		sender.sendMessage(recipient);
	}

}
