package com.shinhan.day08;

public interface Lendable {

	// 상수(final static 생략 가능)
	final static byte STATE_BORROWED = 1; // 대출 중
	byte STATE_NORMAL = 0; // 대출되지 않은 상태

	public abstract void checkOut(String borrower, String date); // 대출 메소드
	// abstract 생략 가능
	void checkIn(); // 반납 메소드

}
