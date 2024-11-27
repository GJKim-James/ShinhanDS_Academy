package com.shinhan.mavenProject.section8;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop8.xml");

		Calculator cal = applicationContext.getBean("cal", Calculator.class);
		cal.add();
		System.out.println();
		cal.add(12, 12);
		System.out.println();
		cal.divide(1, 2);
	}
	
	private static void f2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop8.xml");

		DeptService deptService = applicationContext.getBean("deptService", DeptService.class);
		List<DeptDTO> deptList = deptService.selectAllService();
		
		for (DeptDTO dept : deptList) {
			System.out.println(dept);
		}
	}

}
