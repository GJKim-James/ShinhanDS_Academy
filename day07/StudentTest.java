package com.shinhan.day07;

public class StudentTest {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		// 0. 객체 생성 없이 사용(static이 붙어있는 것은 사용 가능)
		System.out.println("HighSchool.company1 : " + HighSchool.company1);
		System.out.println("HighSchool.company5 : " + HighSchool.company5);
		System.out.println("HighSchool.COMPANY6 : " + HighSchool.COMPANY6);
		System.out.println("HighSchool.COMPANY7 : " + HighSchool.COMPANY7);
		System.out.println("------------------------------");

		// 1. 객체 참조 변수 선언(instance)
		HighSchool s1;

		// 2. 객체 생성
		s1 = new HighSchool("고딩1", 18, 100000);
		System.out.println("------------------------------");

		// 3. 객체 사용
		System.out.println("s1.getName() : " + s1.getName());
		System.out.println("s1.getAge() : " + s1.getAge());
		System.out.println("s1.getPocketMoney() : " + s1.getPocketMoney());
		System.out.println("------------------------------");

	}

	private static void f1() {
		// 0. 객체 생성 없이 사용(static이 붙어있는 것은 사용 가능)
		System.out.println("company1 : " + Student.company1);
		System.out.println("company5 : " + Student.company5);
		System.out.println("COMPANY6 : " + Student.COMPANY6);
		System.out.println("COMPANY7 : " + Student.COMPANY7);
		System.out.println("------------------------------");

		// 1. 객체 참조 변수 선언
		Student st1, st2;

		// 2. 객체 생성
		st1 = new Student(); // st1 : 객체 변수, new Student() : instance
		st2 = new Student();
		System.out.println("------------------------------");

		// 3. 객체 사용
		System.out.println("st1.name : " + st1.name);
		System.out.println("st1.age : " + st1.age);
		System.out.println("st2.name : " + st2.name);
		System.out.println("st2.age : " + st2.age);
		System.out.println("------------------------------");

		st1.name = "홍길동"; // 직접 접근은 지양(getter, setter 사용하는 것이 좋다)
		st1.age = 20; // 직접 접근은 지양(getter, setter 사용하는 것이 좋다)
		st2.setName("김광진");
		st2.setAge(28);
		System.out.println("st1.getName() : " + st1.getName());
		System.out.println("st1..getAge() : " + st1.getAge());
		System.out.println("st2.getName() : " + st2.getName());
		System.out.println("st2.getAge() : " + st2.getAge());
		System.out.println("------------------------------");

		System.out.println("st2.company2 : " + st2.company2);
		System.out.println("st2.company3 : " + st2.company3);
		System.out.println("st2.company4 : " + st2.company4);
		System.out.println("------------------------------");

		System.out.println("Student.company1 : " + Student.company1);
		System.out.println("Student.COMPANY6 : " + Student.COMPANY6);
		System.out.println("Student.COMPANY7 : " + Student.COMPANY7);
	}

}
