package com.shinhan.day15.exam;

class PhoneCharge {
	private String user; // 폰 사용자 이름
	private int call; // 통화시간(분단위)
	private int sms; // 문자전송건수
	private int data; // 데이터통신량(GB단위)
	private int total; // 통신요금(원)

	public PhoneCharge(String user, int call, int sms, int data) {
		super();
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharge() {
//		int callFee = 10; // 통화요금
//		// 기본 10원/1분. 단, call 200분 이상이면 callFee는 기본의 2배로 증가
//		if (call >= 200) {
//			callFee *= 2 * call;
//		} else {
//			callFee *= call;
//		}
		
		int callFee = call * (call >= 200 ? 10 * 2 : 10);

//		int smsFee = 20; // 문자요금
//		// 기본 20원/1건. 단, sms 300건 이상이면 smsFee는 기본의 4배로 증가
//		if (sms >= 300) {
//			smsFee *= 4 * sms;
//		} else {
//			smsFee *= sms;
//		}
		
		int smsFee = sms * (sms >= 300 ? 20 * 4 : 20);

//		int dataFee = 1000; // 데이터통신요금
//		// 기본 1000원/1GB. 단, data 7GB 이상이면 dataFee는 기본의 2배로 증가
//		if (data > 7) {
//			dataFee *= 2 * data;
//		} else {
//			dataFee *= data;
//		}
		
		int dataFee = data * (data >= 7 ? 1000 * 2 : 1000);

		return callFee + smsFee + dataFee;
	}

	public void printCharge() {
		total = calcCharge();
		System.out.println(user + " 사용자는 이번달에 사용하신 전화요금이 " + total + " 원입니다.");
	}
}

class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}
