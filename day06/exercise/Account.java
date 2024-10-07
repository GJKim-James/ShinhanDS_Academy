package com.shinhan.day06.exercise;

// 6장 확인문제 20번
public class Account {
	
	// 1. field(변수) : 값 저장, (정보은닉, 캡슐화) 일반적으로 외부에서 직접 수정, 접근 불가하도록 설정한다.
	private String accNo; // 계좌번호
	private String owner; // 계좌주
	private int balance; // 초기 입금액
	
	// 2. 생성자 : 값 초기화 시 setter 이용하거나 생성자 이용
	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	// 3. 일반 메서드 중에 값 제공, 값 변경 메서드 구현 getter / setter
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account 정보 [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}

}
