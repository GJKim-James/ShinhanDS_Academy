package com.shinhan.mavenProject.section7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop7.xml");
		
		// aop7.xml에서 <bean id="proxyCal"> 읽음
		Calculator cal = applicationContext.getBean("proxyCal", Calculator.class);
		cal.add();
		System.out.println();
		cal.add(100);
		System.out.println();
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
	}

}
