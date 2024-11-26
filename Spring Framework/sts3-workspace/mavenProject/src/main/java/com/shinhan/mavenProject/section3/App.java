package com.shinhan.mavenProject.section3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		f1();
		System.out.println();
		f2();
	}

	private static void f1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di3.xml");
		Car car1 = context.getBean("car1", Car.class);
		Car car2 = context.getBean("car2", Car.class);
		Car car3 = context.getBean("car3", Car.class);
		Car car4 = context.getBean("car4", Car.class);
		
		System.out.println("car1 : " + car1);
		System.out.println("car2 : " + car2);
		System.out.println("car3 : " + car3);
		System.out.println("car4 : " + car4);
	}
	
	private static void f2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di3.xml");
		
		Person p1 = context.getBean("person1", Person.class);
		System.out.println("p1 : " + p1);
	}

}
