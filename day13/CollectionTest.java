package com.shinhan.day13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import com.shinhan.day12.multithread.Account;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Person implements Comparable<Person> {
	String name;
	int age;

	// 나이 순으로 정렬(desc)
	@Override
	public int compareTo(Person obj) {
		return obj.age - age;
	}
}

public class CollectionTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
//		f15();
//		f16();
		f17();
	}

	// Collection > Set > TreeSet
	private static void f17() {
		TreeSet<Person> data = new TreeSet<>();

		data.add(new Person("김1", 20));
		data.add(new Person("김5", 30));
		data.add(new Person("김2", 40));
		data.add(new Person("김4", 50));
		data.add(new Person("김3", 60));

		for (Person p : data) {
			System.out.println(p);
		}
	}

	private static void f16() {
		// TreeSet : 중복 없음(hashCode(), equals())
		// 			 비교 가능(Comparable 반드시 구현해야함)
		TreeSet<Integer> data = new TreeSet<>();

		data.add(100);
		data.add(300);
		data.add(400);
		data.add(500);
		data.add(500);

		// asc
		for (Integer s : data) {
			System.out.println(s);
		}
		System.out.println("----------");

		// desc
		NavigableSet<Integer> navi = data.descendingSet();
		for (Integer n : navi) {
			System.out.println(n);
		}
		System.out.println("----------");

		System.out.println("first : " + data.first());
		System.out.println("last : " + data.last());
		System.out.println("lower : " + data.lower(400));
		System.out.println("higher : " + data.higher(400));
		System.out.println("floor : " + data.floor(450)); // floor : 버림
		System.out.println("ceiling : " + data.ceiling(450)); // ceiling : 올림
		System.out.println();

		System.out.println("===== tailSet =====");
		NavigableSet<Integer> navi2 = data.tailSet(400, true);
		for (Integer n : navi2) {
			System.out.println(n);
		}
		System.out.println();

		System.out.println("===== subSet =====");
		// 100보다 크거나 같고 400보다 작다.
		NavigableSet<Integer> navi3 = data.subSet(100, true, 400, false);
		for (Integer n : navi3) {
			System.out.println(n);
		}
	}

	private static void f15() {
		// 검색을 강화한 컬렉션 : Tree*
		// 중복 불가, 순서 있음(넣을 때 값을 비교해서 이진 트리로 순서 유지)
		// 데이터 간 비교가 가능해야 넣을 수 있음
		TreeSet<Computer> data = new TreeSet<>();

		data.add(new Computer("A2", 500));
		data.add(new Computer("A1", 100));
		data.add(new Computer("A1", 100));
		data.add(new Computer("A4", 100));
		data.add(new Computer("A3", 400));

		for (Computer s : data) {
			System.out.println(s);
		}

		System.out.println("first : " + data.first());
		System.out.println("last : " + data.last());
		System.out.println("lower : " + data.lower(new Computer("A1", 100)));
		System.out.println("higher : " + data.higher(new Computer("A1'", 100)));
		System.out.println("floor : " + data.floor(new Computer("A2'", 200)));
	}

	private static void f14() {
		// 검색을 강화한 컬렉션 : Tree*
		// 중복 불가, 순서 있음(넣을 때 값을 비교해서 이진 트리로 순서 유지)
		// 데이터 간 비교가 가능해야 넣을 수 있음
		TreeSet<Integer> data = new TreeSet<>();

		data.add(100);
		data.add(300);
		data.add(400);
		data.add(500);
		data.add(500);

		for (Integer s : data) {
			System.out.println(s);
		}
	}

	private static void f13() {
		// 검색을 강화한 컬렉션 : Tree*
		TreeSet<String> data = new TreeSet<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f12() {
		// ArrayList, LinkedList : 동기화 처리 안됨
		// Vector : 멀티스레드에 안정적(동기화 처리됨)
		Vector<Integer> data = new Vector<>();

		Thread a = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.add(i);
				}
			};
		};

		Thread b = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.add(i);
				}
			};
		};

		a.start();
		b.start();

		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Vector에 저장된 data 개수 : " + data.size());
	}

	// 동기화된 컬렉션(Synchronized Map)
	private static void f11() {
		// HashMap : 동기화 처리 안됨(데이터 분실)
		// HashTable : 멀티스레드에 안정적(동기화 처리됨)
		Map<String, Integer> data = new Hashtable<>();

		Thread a = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.put(String.valueOf(i), i);
				}
			};
		};

		Thread b = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.put(String.valueOf(i), i);
				}
			};
		};

		System.out.println("Map에 저장된 data 개수 : " + data.size());
	}

	private static void f10() {
		// Map : HashMap, HashTable, TreeMap, Properties
		Properties pro = new Properties();

		try {
			pro.load(CollectionTest.class.getResourceAsStream("oracleDB.properties"));
			for (Object key : pro.keySet()) {
				String s = (String) pro.get(key);
				System.out.println(key + " = " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f9() {
		// Set, List : 값 여러 개 저장
		// Map : Key, Value의 쌍. Key는 Set이다.
		Map<String, Integer> data = new HashMap<>();

		data.put("홍길동3", 100);
		data.put("홍길동1", 200);
		data.put("홍길동1", 700); // 덮어쓰기
		data.put("홍길동5", 300);
		data.put("홍길동2", 400);
		data.put("홍길동4", 500);

		Integer score = data.get("홍길동1");
		System.out.println("홍길동1 점수 : " + score);
		System.out.println("-----------------------------------");

		// keySet() 이용
		Set<String> keys = data.keySet();
		for (String key : keys) {
			score = data.get(key);
			System.out.println(key + " 점수 : " + score);
		}
		System.out.println("-----------------------------------");

		// entrySet() 이용
		Set<Entry<String, Integer>> entrys = data.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey() + " 점수 : " + entry.getValue());
		}
		System.out.println("-----------------------------------");

		// 더 간단히
		for (Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + " 점수 : " + entry.getValue());
		}
		System.out.println("-----------------------------------");
		
		// values
		Collection<Integer> datas = data.values();
		System.out.println(datas);
		
		System.out.println(data.containsKey("홍길동2"));
		System.out.println(data.containsValue(400));
	}

	private static void f8() {
		Set<String> data = new HashSet<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		// 반복자 iterator
		Iterator<String> it = data.iterator();

		System.out.println("========== 반복자 iterator 사용 ==========");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f7() {
		Set<String> data = new HashSet<>();

		data.add("커피");
		data.add("오렌지");

		System.out.println(data.contains("커피"));
		System.out.println(data.contains("커피2"));
		System.out.println("-----------------------------------");

		Set<Computer> data2 = new HashSet<>();

		data2.add(new Computer("A", 100));
		data2.add(new Computer("B", 100));

		// model만 같으면 같은 것(Computer 클래스에서 @EqualsAndHashCode(of = "model") 선언)
		System.out.println(data2.contains(new Computer("A", 100)));
		System.out.println(data2.contains(new Computer("A", 200)));
		System.out.println(data2.contains(new Computer("B", 200)));
		System.out.println(data2.contains(new Computer("C", 200)));
	}

	private static void f6() {
		Set<Computer> data = new HashSet<>();

		data.add(new Computer("ABC", 100));
		data.add(new Computer("DDD", 100));
		data.add(new Computer("ABC", 200)); // model(ABC) 같기 때문에 안들어감

		display2("HashSet(Computer) 이용하기", data);
		System.out.println("-----------------------------------");

		System.out.println(data.contains(new Computer("DDD", 100)));
		System.out.println(data.contains(new Computer("AAA", 100)));
	}

	private static void f5() {
		Set<Account> data = new HashSet<>();

		data.add(new Account("123", "Kim", 1000));
		data.add(new Account("123", "Kim", 2000)); // 안들어감
		data.add(new Account("123", "Kim", 3000)); // 안들어감

		data.add(new Account("123", "Kim", 4000)); // 안들어감
		data.add(new Account("1234", "Kim", 4000));
		data.add(new Account("12345", "Park", 4000));

		display2("HashSet(Account) 이용하기", data);
	}

	private static void f4() {
		// HashSet : 순서 없고, 중복 허용 안함
		Set<String> data = new HashSet<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		// List는 get() 메소드 사용 가능, Set은 get() 메소드 사용 불가; display2() 생성
		display2("HashSet 이용하기", data);
	}

	private static void f3() {
		// ArrayList : 중간 삽입 및 삭제 시 비효율적, 마지막에 데이터 추가 시 효율적
		// LinkedList : 중간 삽입 및 삭제 시 ArrayList보다 효율적
		// Vector : MultiThread 환경에서 안정적 (Synchronized 지원)
		List<String> data = new Vector<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		display("Vector 이용하기", data);
	}

	private static void f2() {
		LinkedList<String> data = new LinkedList<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		display("LinkedList 이용하기", data);
	}

	private static void f1() {
		// List : ArrayList, LinkedList, Vector
		// Set : HashSet(순서 없음, 중복 허용 안함), TreeSet
		ArrayList<String> data = new ArrayList<>();

		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일");
		data.add("일요일");
		data.add("일요일");

		display("ArrayList 이용하기", data);
	}

	private static void display2(String title, Set<?> data) {
		System.out.println("========== " + title + " ==========");
		System.out.println("---------- 향상된 for문 이용 ----------");
		for (Object s : data) {
			System.out.println(s);

			if (s instanceof Account acc) {
				acc.deposit(2000);
				System.out.println("잔고 : " + acc.getBalance());
			}
		}
	}

	private static void display(String title, List<String> data) {
		System.out.println("========== " + title + " ==========");
		System.out.println("---------- 일반 for문 이용 ----------");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}

		System.out.println("---------- 향상된 for문 이용 ----------");
		for (String s : data) {
			System.out.println(s);
		}
	}

}
