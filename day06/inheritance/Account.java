package com.shinhan.day06.inheritance;

/*
 * public : 모든 패키지의 모든 클래스에서 접근 가능
 * protected : 같은 패키지의 모든 클래스에서 접근 가능, 다른 패키지이면 상속받았을 경우에만 접근 가능
 * 생략(default) : 같은 패키지의 모든 클래스에서 접근 가능
 * private : 해당 클래스에서만 접근 가능
 */

// 부모 클래스(상위 클래스, 슈퍼 클래스)
public class Account {
	
	private String accountNo;
	private String ownerName;
	public int balance;
	
	// Java 관련 기술들은 JavaBeans 기술 사용 : default 생성자가 꼭 있어야 한다.
	// JSP, Servlet, Spring, Mybatis, JPA 등 모두 다 JavaBeans 기술 사용
	public Account() {
		System.out.println("1. Account 생성자(부모)");
	}
	
	public Account(String accountNo2, String ownerName2, int balance2) {
		this.accountNo = accountNo2;
		this.ownerName = ownerName2;
		this.balance = balance2;
	}

	void deposit(int amount) {
		balance += amount;
	}
	
	public int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		} else {
			balance -= amount;
			return amount;
		}
	}

	// Getter, Setter
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
