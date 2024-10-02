package com.shinhan.day04.lab;

// Controller : 사용자가 요청을 하면 Service를 통해 처리
public class BookTest {

	public static void main(String[] args) {

		// 배열 생성 : 하나의 이름, 같은 타입의 여러 개의 값을 저장, 개수 모르면 생성 불가
		Book[] b = new Book[5];
		
		// Book 객체 생성
		b[0] = new Book("Java Program", 30000);
		b[1] = new Book("JSP Program", 25000);
		b[2] = new Book("SQL Fundamentals", 20000);
		b[3] = new Book("JDBC Program", 32000);
		b[4] = new Book("EJB Program", 25000);

		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();

	}

}
