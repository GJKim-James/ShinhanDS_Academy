package com.shinhan.day06.inheritance;

public class InheritanceTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
		f8();
		call();
	}

	private static void call() {
		Tire[] arr = new Tire[2];
		
		// 자동 형 변환
		arr[0] = new KumhoTire();
		arr[1] = new HankookTire();
		
		call2(arr);
	}
	
	private static void call2(Tire[] arr) {
		for (Tire tire : arr) {
			// 다형성; 사용법은 같지만 결과가 다름
			tire.roll();
			
			if (tire instanceof HankookTire hankook) { // 한국타이어면 바꾸고, 그렇지 않으면 바꾸지 않음
				// 강제 형 변환
//				HankookTire hankook = (HankookTire) tire;
				hankook.display();
			}
		}
	}

	private static void f8() {
		String s1 = "이것이 자바다";
		Integer i = 100;
		System.out.println("s1의 길이 : " + s1.length());
		
		f9("s1 : " + s1);
		f9("i : " + i);
		System.out.println("----------------------------------------");
	}
	
	private static void f9(Object aa) {
		System.out.println(aa.toString());
		
		if (aa instanceof String s) {
//			String s = (String) aa;
			int len = s.length();
			
			System.out.println("길이 : " + len);
		}
	}

	private static void f7() {
		// 형 변환(자동, 강제)
		int a;
		char ch = 'A';
		
		// 1. 기본형 자동 형 변환 : 큰방 = 작은값
		a = ch;
		System.out.println("a : " + a);
		
		// 2. 기본형 강제 형 변환 : 작은방 = (작은방 타입) 큰값;
		ch = (char) a;
		System.out.println("ch : " + ch);
		System.out.println("----------------------------------------");
		
		// 객체의 형 변환
		// 1. 자동 형 변환 : 부모 = 자식
		// 2. 강제 형 변환 : 자식 = (자식 타입) 부모
		
		Dog animal1 = new Dog();
		Cat animal2 = new Cat();
		System.out.println("----------------------------------------");
		
		useAnimal(animal1);
		useAnimal(animal2);
		System.out.println("----------------------------------------");
	}

	private static void useAnimal(Animal animal) {
		// 사용법은 같지만 결과가 다르다.(다형성)
		animal.sing();
		animal.fly();
		
		// 컴파일 시 오류 없음, 실행 시 animal이 Cat이 아니면 오류
		System.out.println(animal instanceof Cat);
		Cat cat = (Cat) animal;
		cat.play();
	}

	private static void f6() {
		Account acc1 = new Account();
		
		BonusPointAccount acc2 = new BonusPointAccount(null, null, 1000, 0);
		CheckingAccount acc3 = new CheckingAccount(null, null, 2000, null);
		CreditLineAccount acc4 = new CreditLineAccount(null, null, 3000, 0);
		
		acc1.deposit(100);
		acc2.deposit(100);
		acc3.deposit(100);
		acc4.deposit(100);
		
//		acc1.print();
//		acc2.print();
//		acc3.print();
//		acc4.print();
		
		System.out.println("acc1.balance : " + acc1.balance);
		System.out.println("acc2.balance : " + acc2.balance);
		System.out.println("acc3.balance : " + acc3.balance);
		System.out.println("acc4.balance : " + acc4.balance);
		System.out.println("----------------------------------------");
	}

	private static void f5() {
		BonusPointAccount acc = new BonusPointAccount("123", "홍", 1000, 1000);
		acc.deposit(5000);
		System.out.println("acc.balance : " + acc.balance);
		System.out.println("acc.bonusPoint : " + acc.bonusPoint);
		System.out.println("----------------------------------------");
	}

	private static void f4() {
		CreditLineAccount acc1 = new CreditLineAccount("123", "aa", 1000, 500);
		
		acc1.deposit(2000);
		System.out.println(acc1.balance);
		
		int amount = acc1.withdraw(3600);
		System.out.println("출금 : " + amount);
		System.out.println("잔고 : " + acc1.balance);
		System.out.println("----------------------------------------");
	}

	private static void f3() {
		Child ch = new Child();
//		ch.f2();
		ch.f1();
		System.out.println("ch.a : " + ch.a);
		System.out.println("----------------------------------------");
	}

	// Parent, Child 클래스
	private static void f2() {
		Child ch = new Child();
		ch.f2();
		System.out.println("----------------------------------------");
	}

	// Account, CheckingAccount 클래스
	private static void f1() {
		CheckingAccount acc = new CheckingAccount("111-222", "홍길동", 10000, "7777");
		System.out.println("잔고(acc.getBalance()) : " + acc.getBalance());
//		acc.accountNo = "111-111";
//		acc.ownerName = "홍길동";
//		acc.balance = 1000;
		
		acc.deposit(1000);
		System.out.println("잔고(acc.getBalance()) : " + acc.getBalance());
		
		int amount = acc.withdraw(500);		
		System.out.println("출금 금액 : " + amount);
		System.out.println("잔고(acc.getBalance()) : " + acc.getBalance());
		
		amount = acc.pay("7777", 10000);
		System.out.println("출금 금액 : " + amount);
		System.out.println("잔고(acc.getBalance()) : " + acc.getBalance());
		System.out.println("----------------------------------------");
	}

}
