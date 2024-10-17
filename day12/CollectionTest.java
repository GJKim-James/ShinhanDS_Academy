package com.shinhan.day12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.shinhan.day12.multithread.Account;

// Collection : List, Set, Map
// List : 순서 있고, 중복 허용; ArrayList, Vector, LinkedList
// Set : 순서 없고, 중복 불가; HashSet, TreeSet
public class CollectionTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	// HashSet
	private static void f6() {
		// Account 클래스에서 @EqualsAndHashCode를 이용해 hashCode(), equals() 재정의 후
		// accountNo과 ownerName이 같은 값은 저장 안됨
		HashSet<Account> data = new HashSet<>();

		data.add(new Account("123", "Kim", 1000));
		data.add(new Account("123", "Kim", 2000));
		data.add(new Account("124", "Lee", 3000));

		for (Account s : data) {
			System.out.println(s);
		}		
	}

	// HashSet
	private static void f5() {
		// String 클래스 중복 Check : hashCode(), equals() 재정의됨
		HashSet<String> data = new HashSet<>();

		data.add("월");
		data.add("월");
		data.add("토");
		data.add("토");

		for (String s : data) {
			System.out.println(s);
		}
	}

	// Vector
	private static void f4() {
		List<String> aList = new Vector<>();

		aList.add("월");
		aList.add("토");
		aList.add("토");
		aList.add("일");

		print(aList);

		System.out.println("aList.contains(\"토\")? " + aList.contains("토"));
		System.out.println("aList.size() : " + aList.size());

		aList.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		// 람다식으로
//		aList.sort((a, b) -> {
//			
//		});
		print(aList);
	}

	// LinkedList
	private static void f3() {
		List<String> aList = new LinkedList<>();

		aList.add("월");
		aList.add("토");
		aList.add("토");
		aList.add("일");

		print(aList);
	}

	private static void print(List<String> aList) {
		for (String s : aList) {
			System.out.println(s);
		}
	}

	// ArrayList
	private static void f2() {
		ArrayList<String> aList = new ArrayList<>();

		aList.add("월");
		aList.add("토");
		aList.add("토");
		aList.add("일");

		print(aList);
	}

	private static void print(ArrayList<String> aList) {
		for (String s : aList) {
			System.out.println(s);
		}
	}

	private static void f1() {
		ArrayList aList = new ArrayList();
		aList.add(100);
		aList.add("자바");
		aList.add(new Account("123", "lee", 1000));

		int a = (Integer) aList.get(0);
		String a2 = (String) aList.get(1);
		Account a3 = (Account) aList.get(2);
		
		System.out.println(a);
		System.out.println(a2);
		System.out.println(a3);
	}

}
