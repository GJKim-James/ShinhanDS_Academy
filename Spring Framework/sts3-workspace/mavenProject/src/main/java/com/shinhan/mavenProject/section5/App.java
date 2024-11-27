package com.shinhan.mavenProject.section5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shinhan.mavenProject.section4.CarVO;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CarVO car = context.getBean("getCar", CarVO.class);
		System.out.println(car);
	}

}
