package com.shinhan.day12.wildcard;

// 와일드카드 타입 파라미터
public class GenericExample {

	public static void main(String[] args) {
		Person p = new Person();
		Student s = new Student();
		Worker w = new Worker();
		HighStudent h = new HighStudent();
		MiddleStudent m = new MiddleStudent();

		Applicant<Person> a1 = new Applicant<>(p);
		Applicant<Student> a2 = new Applicant<>(s);
		Applicant<Worker> a3 = new Applicant<>(w);
		Applicant<HighStudent> a4 = new Applicant<>(h);
		Applicant<MiddleStudent> a5 = new Applicant<>(m);

		// 모든 사람이 신청 가능
		Course.registerCourse1(a1);
		Course.registerCourse1(a2);
		Course.registerCourse1(a3);
		Course.registerCourse1(a4);
		Course.registerCourse1(a5);
		System.out.println();

		// 학생만 신청 가능
//		Course.registerCourse2(a1); // Person X
		Course.registerCourse2(a2); // Student O
//		Course.registerCourse2(a3); // Worker X
		Course.registerCourse2(a4); // HighStudent O
		Course.registerCourse2(a5); // MiddleStudent O
		System.out.println();

		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(a1); // Person O
//		Course.registerCourse3(a2); // Student X
		Course.registerCourse3(a3); // Worker O
//		Course.registerCourse3(a4); // HighStudent X
//		Course.registerCourse3(a5); // MiddleStudent X
	}

}
