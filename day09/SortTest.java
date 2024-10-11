package com.shinhan.day09;

import java.util.Arrays;
import java.util.Comparator;

//자바의 규칙 : Comparator 인터페이스를 반드시 구현해야한다.
//제네릭스 : 사용할 때 타입을 결정한다. 기본형은 불가 int => Integer
class MyDescSort implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// asc : < 0같다 >
		return o2 - o1;
	}

}

class MyDescSort2 implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// desc : < 0같다 >
		return o1.compareTo(o2) * -1;
//		return o1 - o2;
	}

}

public class SortTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}

	private static void f7() {
		Student[] arr = new Student[5];

		arr[0] = new Student("홍길동", 100);
		arr[1] = new Student("김길동", 90);
		arr[2] = new Student("박길동", 100);
		arr[3] = new Student("송길동", 30);
		arr[4] = new Student("정길동", 80);

		print("Before", arr);

		Arrays.sort(arr);
		print("After(점수순 desc, 이름순 asc)", arr);

		// 익명 구현 클래스
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.name.compareTo(o1.name);
			}

		});
//		Arrays.sort(arr, (a, b) -> b.name.compareTo(a.name)); // 람다 표현식으로 나타내기
		print("After(이름순 desc)", arr);
//		System.out.println("Before : " + Arrays.toString(arr));
	}

	private static void print(String title, Student[] arr) {
		System.out.println("========== " + title + " ==========");
		for (Student st : arr) {
			System.out.println(st);
		}
	}

	private static void f6() {
		String[] arr = { "java", "web", "sql", "framework", "react" };
		System.out.println("Before : " + Arrays.toString(arr));

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// desc
				return o2.compareTo(o1);
			}
		});
		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f5() {
		String[] arr = { "java", "web", "sql", "framework", "react" };
		System.out.println("Before : " + Arrays.toString(arr));

//		Arrays.sort(arr, new MyDescSort2());
		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f4() {
		String[] arr = { "java", "web", "sql", "framework", "react" };
		System.out.println("Before : " + Arrays.toString(arr));

		Arrays.sort(arr); // asc
		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f3() {
		Integer[] arr = { 10, 3, 7, 20, 5 };
		System.out.println("Before : " + Arrays.toString(arr));

		Arrays.sort(arr, (o1, o2) -> (o1 - o2) * -1); // desc
		System.out.println("After : " + Arrays.toString(arr));
	}
	
	private static void f2() {
		Integer[] arr = { 10, 3, 7, 20, 5 };
		System.out.println("Before : " + Arrays.toString(arr));

		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 - o2) * -1; // desc
			}
		});
		System.out.println("After : " + Arrays.toString(arr));
	}
	
	private static void f1() {
//		int[] arr = new int[] {
//				
//		};
		Integer[] arr = { 10, 3, 7, 20, 5 };
		System.out.println("Before : " + Arrays.toString(arr));

		Arrays.sort(arr, new MyDescSort()); // desc
		System.out.println("After : " + Arrays.toString(arr));
	}

}
