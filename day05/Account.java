package com.shinhan.day05;

/*
 * 계좌(Account) 클래스는 계좌 번호를 나타내는 accNo 데이터와 잔고를 나타내는 balance 데이터를 가지고 있습니다.
 * 함수로는 입금을 의미하는 deposit 함수와 출금을 의미하는 withdraw 함수 및 잔고를 확인하는 getBalance 함수와
 * 계좌 번호를 확인하는 getAccNo 함수를 가지고 있습니다.
 * TestAccount 클래스를 이용하여 Account 클래스의 함수를 호출시켰을 때 콘솔에 출력되는 결과는 다음과 같습니다.
 * 
 * [TestAccount 실행결과]
 * 078-3762-293 계좌가 개설되었습니다.
 * 078-3762-293 계좌의 잔고는 1000000원입니다.
 * 078-3762-293 계좌에 2000000원이 입금되었습니다.
 * 078-3762-293 계좌의 잔고는 3000000원입니다.
 * 078-3762-293 계좌에 500000원이 출금되었습니다.
 * 078-3762-293 계좌의 잔고는 3500000원입니다.
 */
public class Account {
	
	private String accNo; // 계좌 번호 (new로 생성 시 자동 초기화)
	private int balance; // 잔고 (new로 생성 시 자동 초기화)
	public static int count; // 계좌 개수(load 시 자동 초기화)

	public Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		
		print(" 계좌가 개설");
		count++; // 계좌 개수 증가
	}

	private void print(String message) {
		System.out.println(accNo + message + "되었습니다.");
		System.out.println(accNo + " 계좌의 잔고는 " + balance + "원입니다.");
	}

	// 입금
	public void deposit(int amount) {
		balance += amount;
		print(" 계좌에 " + amount + "원이 입금");
	}

	// 출금
	public void withdraw(int amount) {
		balance -= amount;
		print(" 계좌에 " + amount + "원이 출금");
	}

	public String getAccNo() {
		return accNo;
	}

//	public void setAccNo(String accNo) {
//		this.accNo = accNo;
//	}

	public int getBalance() {
		return balance;
	}

//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
}
