package com.shinhan.mavenProject.section4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	public static void main(String[] args) {
		// di4.xml에서 <bean> 생성함으로써 setter 역할의 DI(의존성 주입)
//		CarVO car = new CarVO();
//		car.setModel("ABC");
//		car.setPrice(1000);
//		car.setColor("black");

		// di4.xml에서 <bean> 생성함으로써 setter 역할의 DI(의존성 주입)
//		PersonVO p1 = new PersonVO();
//		p1.setName("김광진");
//		p1.setAge(28);
//		p1.setCar(car);

		f1(); // Spring Injection(DI)
		System.out.println();
		f2(); // 의존 관계 자동 설정(byName, byType)
		System.out.println();
		f3(); // Bean 객체의 범위(singleton; default, prototype, request, session)
	}

	private static void f1() {
		// Spring Container(bean 생성)
		ApplicationContext context = new ClassPathXmlApplicationContext("di4.xml");

		// 생성된 객체(bean) 얻기
		PersonVO p1 = context.getBean("person1", PersonVO.class);
		System.out.println("getName : " + p1.getName());
		System.out.println("getAge : " + p1.getAge());
		System.out.println("getCar : " + p1.getCar());
		System.out.println("getMajor : " + p1.getMajor());
		System.out.println("getLicenseList : " + p1.getLicenseList());
		System.out.println("getBookMap : " + p1.getBookMap());
		System.out.println("getFriends : " + p1.getFriends());
		System.out.println("getMyProfile : " + p1.getMyProfile());
	}

	private static void f2() {
		// Spring Container(bean 생성)
		ApplicationContext context = new ClassPathXmlApplicationContext("di4.xml");

		// 생성된 객체(bean) 얻기
		PersonVO p2 = context.getBean("person2", PersonVO.class);
		System.out.println("getName : " + p2.getName());
		System.out.println("getAge : " + p2.getAge());
		System.out.println("getCar : " + p2.getCar());
		System.out.println("getMajor : " + p2.getMajor());
		System.out.println("getLicenseList : " + p2.getLicenseList());
		System.out.println("getBookMap : " + p2.getBookMap());
		System.out.println("getFriends : " + p2.getFriends());
		System.out.println("getMyProfile : " + p2.getMyProfile());
	}

	private static void f3() {
		// Spring Container(bean 생성)
		ApplicationContext context = new ClassPathXmlApplicationContext("di4.xml");

		// 생성된 객체(bean) 얻기
		PersonVO p1 = context.getBean("person2", PersonVO.class);
		PersonVO p2 = context.getBean("person2", PersonVO.class);
		System.out.println("p1==p2? " + (p1 == p2)); // true(같은 객체)
		// Spring Bean 생성 default = singleton
	}

}
