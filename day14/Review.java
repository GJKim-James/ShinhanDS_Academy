package com.shinhan.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

interface MyInterface {
	static void method() {
		
	}
}

public class Review {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3(); // 람다식
	}

	private static void f3() {
		// 2. 익명 구현 + 즉시 실행
		(new MyInterface() {
			public void method() {
				System.out.println("2. 익명 구현");
			}
		}).method();
		
		MyInterface a = new MyInterface() {
			public void method() {
				System.out.println("익명 구현");
			}
		};
	}

	private static void f2() {
		Map<Person, Integer> a = new HashMap<>();
		
		a.put(new Person("홍길동1", 10), 100);
		a.put(new Person("홍길동5", 20), 100);
		a.put(new Person("홍길동3", 30), 100);
		a.put(new Person("홍길동2", 40), 100);
		a.put(new Person("홍길동4", 50), 100); // Person 클래스에 @EqualsAndHashCode 선언 시 안들어감
		a.put(new Person("홍길동4", 50), 100);
		
		for (Person p : a.keySet()) {
			System.out.println(p + ": " + a.get(p));
		}
	}

	private static void f1() {
		// Array : 연속 공간, 같은 타입, 고정 개수
		// Collection 인터페이스 : 연속 공간 or 연속 공간 X, 같은 타입 or X, 동적
		// List 인터페이스 : 넣는 순서가 있음(index), 중복 허용, ArrayList, LinkedList, Vector
		// Set 인터페이스 : 넣는 순서가 없음, 중복 허용 X(add 시 check; hashCode(), equals 같으면 넣지 않음)
		//				  HashSet, TreeSet(add 시 비교해서 순서대로 넣는다, Comparable 혹은 Comparator의 compare())
		// Map 인터페이스 : Key, Value의 쌍 / Key는 Set이다.
		
//		List<Integer> a = new ArrayList<>();
//		List<Integer> a = new LinkedList<>();
//		List<Integer> a = new Vector<>();
//		Set<Integer> a = new HashSet<>();
//		Set<Integer> a = new TreeSet<>();
//		Set<Integer> a = new TreeSet<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1; // desc
//			}
//		});
		Set<Integer> a = new TreeSet<>((o1, o2) -> (o2 - o1)); // 람다식, desc
		
		a.add(10);
		a.add(30);
		a.add(50);
		a.add(40);
		a.add(20);
		
		System.out.println(a);
	}

}
