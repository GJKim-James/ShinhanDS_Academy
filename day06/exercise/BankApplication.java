package com.shinhan.day06.exercise;

import java.util.Scanner;

//6장 확인문제 20번
public class BankApplication {
	
	static Scanner sc = new Scanner(System.in);
	
	static Account[] arrAccount = new Account[100];
	static int sequence = 0; // 계좌 100개 구분하기 위한 변수
	
	public static void main(String[] args) {
		System.out.println("===== 반갑습니다. BankApplication 시작 =====");
		
		boolean isStop = false;
		
		while(!isStop) {
			menuDisplay();
			
			int num = numSelect();
			
			switch (num) {
				case 1 -> {
					makeAccount(); // 계좌 생성
				}
				case 2 -> {
					printAccountList(); // 계좌 목록
				}
				case 3 -> {
					depositAccount(); // 예금
				}
				case 4 -> {
					withdrawAccount(); // 출금
				}
				case 5 -> {
					isStop = true; // 종료
				}
				default -> {
					System.out.println("잘못된 숫자 입력입니다. 1 ~ 5 중에서 입력해주세요.");
				}
			}
		}
		
		sc.close();
		
		System.out.println("========== BankApplication 끝 ==========");
	}

	// 4.출금
	private static void withdrawAccount() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("출금액: ");
		int amount = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < arrAccount.length; i++) {
			if (arrAccount[i] == null) {
				break;
			}
			if (accNo.equals(arrAccount[i].getAccNo())) {
				int balance = arrAccount[i].getBalance();
				if (balance < amount) {
					System.out.println("잔액부족 출금불가");
				} else {
					arrAccount[i].setBalance(balance - amount);					
				}
				return;
			}
		}
		System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
	}

	// 3.예금
	private static void depositAccount() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("예금액: ");
		int amount = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < arrAccount.length; i++) {
			if (arrAccount[i] == null) {
				break;
			}
			if (accNo.equals(arrAccount[i].getAccNo())) {
				int balance = arrAccount[i].getBalance();
				arrAccount[i].setBalance(balance + amount);
				return;
			}
		}
		System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
	}

	// 2.계좌목록
	private static void printAccountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		
		for (Account account : arrAccount) {
			if (account == null) {
				break; // break : 반복문 빠지기, return : 함수 빠지기
			} else {
				System.out.printf("%s\t%s\t%d\n", account.getAccNo(), account.getOwner(), account.getBalance());
			}
		}
	}

	// 1.계좌생성
	private static void makeAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("계좌주: ");
		String owner = sc.nextLine();
		System.out.print("초기입금액: ");
		int balance = Integer.parseInt(sc.nextLine());
		arrAccount[sequence] = new Account(accNo, owner, balance);
		sequence++;
		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	private static int numSelect() {
		System.out.print("선택> ");
		return Integer.parseInt(sc.nextLine());
	}

	private static void menuDisplay() {
		System.out.println("-------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("-------------------------------------------");
	}

}
