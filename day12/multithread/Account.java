package com.shinhan.day12.multithread;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 스레드 간의 커뮤니케이션; critical section의 동기화

@EqualsAndHashCode(of = { "accountNo", "ownerName" })
@ToString
@Getter
@Setter
public class Account {

	String accountNo; // 계좌번호
	String ownerName; // 예금주 이름
	int balance; // 잔액

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 입금
	public void deposit(int amount) {
		balance += amount;
	}

	// 출금
	public int withdraw(int amount) {
		if (balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}

}
