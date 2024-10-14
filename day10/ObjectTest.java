package com.shinhan.day10;

import java.util.HashSet;

import com.shinhan.day10.dto.BookDTO;
import com.shinhan.day10.dto.BookDTO2;

public class ObjectTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}
	
	// BookDTO2에 @Builder 사용
	private static void f7() {
		BookDTO2 book = BookDTO2.builder()
				.title("이것이 자바다")
				.price(50000)
				.build();
		
		System.out.println(book);
	}

	private static void f6() {
		BookDTO book = new BookDTO("이것이 자바다", 38000);
		BookDTO book2 = new BookDTO("이것이 코테다", 38000);
		
		System.out.println(book.title());
		System.out.println(book.price());
		
		System.out.println(book2.title());
		System.out.println(book2.price());
	}

	private static void f5() {
		HashSet<Student> set = new HashSet<Student>();
		
		set.add(new Student("홍길동1", 100L, "컴공"));
		set.add(new Student("홍길동2", 100L, "컴공"));
		set.add(new Student("홍길동3", 100L, "컴공"));
		set.add(new Student("홍길동4", 100L, "컴공"));
		set.add(new Student("홍길동5", 100L, "컴공"));
		
		System.out.println(set);
	}

	private static void f4() {
		Student st1 = new Student("홍길동1", 100L, "컴공");
		Student st2 = new Student("홍길동2", 100L, "컴공");
		System.out.println(st1.toString());
		System.out.println(st2.toString());
		System.out.println(System.identityHashCode(st2));
		
		System.out.println(st1 == st2 ? "주소 같음" : "주소 다름");
		System.out.println(st1.equals(st2) ? "내용 같음" : "내용 다름");
	}
	
	private static void f3() {
		Integer int1 = new Integer(100);
		Integer int2 = new Integer(100);
		System.out.println(int1.toString());
		System.out.println(int2.toString());
		System.out.println(System.identityHashCode(int2));
		
		System.out.println(int1 == int2 ? "주소 같음" : "주소 다름");
		System.out.println(int1.equals(int2) ? "내용 같음" : "내용 다름");
	}
	
	private static void f2() {
		String str1 = new String("Java");
		String srt2 = new String("Java");
		System.out.println(str1.toString());
		System.out.println(srt2.toString());
		System.out.println(System.identityHashCode(srt2));
		
		System.out.println(str1 == srt2 ? "주소 같음" : "주소 다름");
		System.out.println(str1.equals(srt2) ? "내용 같음" : "내용 다름");
	}

	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(System.identityHashCode(obj2));
		
		System.out.println(obj1 == obj2 ? "주소 같음" : "주소 다름");
		System.out.println(obj1.equals(obj2) ? "주소 같음" : "주소 다름");
	}

}
