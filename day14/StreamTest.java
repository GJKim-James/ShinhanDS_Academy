package com.shinhan.day14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
//		method9();
//		method10();
//		method11();
//		method12();
//		method13();
//		method14();
//		method15();
//		method16();
//		method17();
//		method18();
//		method19();
		method20();
	}
	
	// 요소 수집
	private static void method20() {
		List<String> alist = new ArrayList<>();
		
		alist.add("A");
		alist.add("BB");
		alist.add("CCC");
		alist.add("DDDD");
		alist.add("DDDDD");
		
		System.out.println("List : " + alist);
		
		// Set으로 바꾸기
		Set<String> aSet = alist.stream().collect(Collectors.toSet());
		System.out.println("Set : " + aSet);
		
		// Map으로 바꾸기
//		Map<String, Integer> aMap = alist.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
		Map<String, Integer> aMap = alist.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println("Map : " + aMap);
	}

	// 요소 커스텀 집계(reduce())
	private static void method19() {
		List<Person> alist = new ArrayList<>();

		alist.add(new Person("홍길동", 20));
		alist.add(new Person("김광진", 30));
		alist.add(new Person("이태한", 40));
		alist.add(new Person("박은지", 50));
		alist.add(new Person("김용범", 50));
		
		int sum = alist.stream().mapToInt(s -> s.getAge()).sum();
		int sum2 = alist.stream().mapToInt(s -> s.getAge()).reduce(0, (a, b) -> (a + b));
		System.out.println("나이 합 : " + sum);
		System.out.println("나이 합 : " + sum2);
	}

	// 요소 커스텀 집계(reduce())
	private static void method18() {
		int[] arr = { 21, 41, 61, 7 };
		int i = Arrays.stream(arr).reduce((a, b) -> (a + b)).getAsInt();
		System.out.println(i);
	}

	// 요소 기본 집계
	private static void method17() {
		int[] arr = { 2, 4, 6, 7 };
		
		long result = Arrays.stream(arr).filter(a -> (a % 2 == 0)).count();
		System.out.println("짝수 개수 : " + result);
		
		long result2 = Arrays.stream(arr).filter(a -> (a % 2 == 0)).sum();
		System.out.println("짝수들의 합계 : " + result2);
		
		OptionalDouble result3 = Arrays.stream(arr).filter(a -> (a % 2 == 0)).average();
//		double avg = result3.getAsDouble();
		double avg = result3.orElse(0); // 짝수가 없으면 0 리턴
		System.out.println("짝수들의 평균 : " + avg);
		System.out.println("짝수들의 평균 : " + (result3.isPresent() ? result3.getAsDouble() : 0));
		
		OptionalInt result4 = Arrays.stream(arr).filter(a -> (a % 2 == 0)).max();
		int i = result4.orElse(0);
		System.out.println("짝수 중 최대값 : " + i);
		
		OptionalInt result5 = Arrays.stream(arr).filter(a -> (a % 2 == 0)).findFirst();
		int j = result5.orElse(0);
		System.out.println("짝수 중 첫 번째 요소 : " + j);
	}

	// 요소 조건 만족 여부(매칭)
	private static void method16() {
		int[] arr = { 2, 4, 6 };
		// allMatch() : 모든 요소가 만족하는지 여부
		boolean result = Arrays.stream(arr).allMatch(value -> (value % 2 == 0));
		System.out.println(result);
		
		int[] arr2 = { 2, 4, 6, 7 };
		// anyMatch() : 최소한 하나의 요소가 만족하는지 여부
		boolean result2 = Arrays.stream(arr2).anyMatch(value -> (value % 2 == 0));
		System.out.println(result2);
		
		int[] arr3 = { 2, 4, 6, 7 };
		// noneMatch() : 모든 요소가 만족하지 않는지 여부
		boolean result3 = Arrays.stream(arr3).noneMatch(value -> (value % 2 == 0));
		System.out.println(result3);
	}

	// 요소를 하나씩 처리(루핑)
	private static void method15() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		Arrays.stream(arr).filter(i -> (i % 2 == 0)).forEach(i -> System.out.println(i));
		System.out.println("----------");
		int sum = Arrays.stream(arr).filter(i -> (i % 2 == 0)).peek(i -> System.out.println(i)).sum();
		System.out.println("sum : " + sum);
		
		int[][] arr2 = { { 10, 20 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1 }, { 1, 2, 3 } };
//		Arrays.stream(arr2).filter(a -> (a.length >= 2)).flatMapToInt(a -> Arrays.stream(a))
	}

	private static void method14() {
		// TODO Auto-generated method stub

	}

	private static void method13() {
		String account = "112-1888451234-5";

		IntStream is = account.chars();
		account.chars().forEach(ch -> System.out.println((char) ch));
		System.out.println("----------");

		int total = IntStream.range(1, 11).sum();
		System.out.println(total);
	}

	// 계좌번호검색 알고리즘 풀이법
	private static void method12() {
		// 규칙 1 : 숫자와 '-'만 포함
		// 규칙 2 : 숫자는 11개 이상 14개 이하
		// 규칙 3, 4 : '-'는 0개 이상 3개 이하, 연속하지 않음, 시작과 끝에 없음
		String account = "112-18845-1234-58";

		if (!account.matches("[0-9-]+")) {
			System.out.println("규칙1 틀림");
		}

//		System.out.println(Character.isDigit('a'));
		long count = account.chars().filter(c -> Character.isDigit(c)).count();
		if (count < 11L || count > 14L) {
			System.out.println("규칙2 틀림");
		}

		long dashCount = account.chars().filter(c -> c == '-').count();
		if (dashCount < 0 || dashCount > 3) {
			System.out.println("규칙3, 4 틀림");
		}

		if (account.contains("--") || account.startsWith("-") || account.endsWith("-")) {
			System.out.println("규칙3, 4 틀림");
		}
	}

	// 요소 변환(매핑)
	private static void method11() {
		List<String> list = Arrays.asList("10, 20", "30, 40, 50", "60, 70, 80, 90, 100");

		// flatMapToInt() : 들어간 값 펼치기, IntStream 리턴
		list.stream().flatMapToInt(s -> {
			String[] arr = s.split(",");
			int[] intArr = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				intArr[i] = Integer.parseInt(arr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(i -> System.out.println(i));
		System.out.println("--------------------");

		double avg = list.stream().flatMapToInt(s -> {
			String[] arr = s.split(",");
			int[] intArr = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				intArr[i] = Integer.parseInt(arr[i].trim());
			}
			return Arrays.stream(intArr);
		}).average().getAsDouble();
		System.out.println("avg : " + avg);
		System.out.println("--------------------");

		// 람다식
		double avg2 = list.stream()
				.flatMapToInt(s -> Arrays.stream(s.split(",")).mapToInt(a -> Integer.parseInt(a.trim()))).average()
				.getAsDouble();
		System.out.println("avg2: " + avg2);
	}

	// 요소 변환(매핑)
	private static void method10() {
		List<String> alist = new ArrayList<>();

		alist.add("this is java");
		alist.add("i am a best developer");

		alist.stream().forEach(s -> System.out.println(s));
		System.out.println("----------------------------------------");

//		alist.stream().mapToInt(s -> s.length()).forEach(s -> System.out.println(s));

		alist.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(s -> System.out.println(s));
		;
	}

	// 요소 변환(매핑)
	private static void method9() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };

		// asDoubleStream() : int, long -> double
		Arrays.stream(arr).asDoubleStream().forEach(n -> System.out.println(n));

		// boxed() : int -> Integer, long -> Long, double -> Double
		Arrays.stream(arr).boxed().forEach(n -> System.err.println(n));
	}

	// 요소 변환(매핑)
	private static void method8() {
		List<Person> alist = new ArrayList<>();

		alist.add(new Person("홍길동", 20));
		alist.add(new Person("김광진", 30));
		alist.add(new Person("이태한", 40));
		alist.add(new Person("박은지", 50));
		alist.add(new Person("김용범", 50));

		alist.stream().mapToInt(p -> p.getAge()).forEach(i -> System.out.println(i));

		// stream 시작 : alist.stream()
		// 중간 처리 : mapToInt(p -> p.getAge()); 들어간 객체를 int로 변경되어 리턴
		// 최종 처리 : average()
		// getAsDouble() : Optional -> 기본형 변경
		double avg = alist.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
		System.out.println(avg);
	}

	// Predicate
	private static void method7() {
		Predicate<Integer> f = a -> (a > 90);
		System.out.println(f.test(100)); // true
		System.out.println(f.test(50)); // false

		Predicate<Person> f2 = p -> p.getName().length() == 3;
		boolean result = f2.test(new Person("홍길동", 28));
		System.out.println(result); // true

		IntPredicate f3 = a -> (a > 90);
		System.out.println(f3.test(50)); // false
	}

	// 요소 걸러내기(필터링)
	private static void method6() {
		List<Person> alist = new ArrayList<>();

		alist.add(new Person("홍길동", 20));
		alist.add(new Person("김광진", 30));
		alist.add(new Person("이태한", 40));
		alist.add(new Person("박은지", 50));
		alist.add(new Person("김용범", 50));

		// distinct() : 중복 제거
		alist.stream().distinct().forEach(p -> System.out.println(p));
		System.out.println("------------------------------------------------------------");

		// filter
		alist.stream().filter(p -> p.getName().startsWith("김")).forEach(p -> {
			System.out.println(p);
		});
		;
		System.out.println("------------------------------------------------------------");

		// predicate : 조건에 맞는가? true, false
		// filter : true 인 것만 선택
		alist.stream().filter(p -> p.getAge() >= 30).forEach(p -> {
			System.out.println(p);
		});
		System.out.println("------------------------------------------------------------");

		// 외부 반복자(stream 이용하는 것보다 비효율적)
		for (Person p : alist) {
			if (p.getName().startsWith("김")) {
				System.out.println(p);
			}
		}
	}

	// 병렬 처리 스트림, 중간 처리, 최종 처리
	private static void method5() {
		List<Person> alist = new ArrayList<>();

		alist.add(new Person("홍길동", 20));
		alist.add(new Person("홍길동2", 30));
		alist.add(new Person("홍길동3", 40));
		alist.add(new Person("홍길동4", 50));

		alist.stream().forEach(p -> System.out.println(p));
		System.out.println("------------------------------------------------------------");

		// 병렬 처리 스트림
		alist.parallelStream().forEach(p -> {
			System.out.println("[" + Thread.currentThread().getName() + "] : " + p);
		});
		System.out.println("------------------------------------------------------------");

		// 시작 : alist.stream()
		// 중간 처리 : mapToInt(); 객체를 int 값으로 매핑해서 IntStream으로 변환(map은 변형하는 것)
		// 최종 처리 : average()
		OptionalDouble op = alist.stream().mapToInt(p -> p.getAge()).average(); // 나이를 가져와서 평균 구하기
//		double result = op.getAsDouble(); // OptionalDouble이 double 일 수도 아닐수도 있다는 뜻, getAsDouble()로 double로 받기
		double result = op.orElse(0); // 값이 없으면 0 리턴
		System.out.println(result);
	}

	// 파일로부터 스트림 얻기
	private static void method4() {
		try {
			Path path = Paths.get(StreamTest.class.getResource("data.txt").toURI());
			System.out.println(path);

			Files.lines(path).forEach(line -> {
				System.out.println(line);
			});
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 숫자 범위로부터 스트림 얻기
	private static void method3() {
		IntStream.range(1, 11).forEach(i -> System.out.println(i)); // 끝에서 -1
		System.out.println("------------------------------");
		IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(i)); // 끝에서 -1 안함
	}

	// 배열, 컬렉션으로부터 스트림 얻기
	private static void method2() {
		// 내부 반복자
		String[] arr = { "A", "B", "C", "D" };
		Integer[] arr2 = { 10, 20, 30, 40, 50 };

		List<Person> alist = new ArrayList<>();
		alist.add(new Person("홍길동", 20));
		alist.add(new Person("홍길동2", 30));
		alist.add(new Person("홍길동3", 40));
		alist.add(new Person("홍길동4", 50));

		Set<Person> alist2 = new HashSet<>();

		Arrays.stream(arr).forEach(a -> {
			System.out.println(a);
		});
		System.out.println("------------------------------");

		Arrays.stream(arr2).forEach(i -> {
			System.out.println(i);
		});
		;
		System.out.println("------------------------------");

		alist.stream().forEach(p -> {
			System.out.println(p);
		});
	}

	// 배열, 컬렉션으로부터 스트림 얻기
	private static void method1() {
		// 외부 반복자
		String[] arr = { "A", "B", "C", "D" };

		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("----------");

		List<String> aList = List.of(arr);
		Iterator it = aList.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
