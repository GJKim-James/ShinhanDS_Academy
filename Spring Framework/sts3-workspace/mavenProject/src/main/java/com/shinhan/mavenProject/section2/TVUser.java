package com.shinhan.mavenProject.section2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {
	
	public static void main(String[] args) {
		f1();
		System.out.println("--------------------");
		f2();
	}

	private static void f1() {
		// BeanFactory 이용
		Resource resource = new ClassPathResource("di2.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		TVInterface tv = (TVInterface) factory.getBean("samsung");
		tv.turnOn();
		tv.turnOff();
	}
	
	private static void f2() {
		// 사용하기 전에 빈(Bean)을 로딩(만든다)
		ApplicationContext context = new ClassPathXmlApplicationContext("di2.xml");
		
		TVInterface tv = context.getBean("samsung", TVInterface.class);
		TVInterface tv2 = context.getBean("lg", TVInterface.class);
		
		tv.turnOn();
		tv.turnOff();
		tv2.turnOn();
		tv2.turnOff();
	}

}
