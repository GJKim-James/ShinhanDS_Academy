package com.shinhan.mavenProject.section6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("di6.xml");
		
		DeptService deptService = applicationContext.getBean("deptService", DeptService.class);
		List<DeptDTO> deptList = deptService.selectAll();
		
		for (DeptDTO dept : deptList) {
			System.out.println(dept);
		}
	}

}
