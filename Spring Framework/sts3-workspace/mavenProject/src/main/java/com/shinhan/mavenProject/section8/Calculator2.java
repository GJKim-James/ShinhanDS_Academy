package com.shinhan.mavenProject.section8;

import org.springframework.stereotype.Component;

// 주업무(Target)
@Component("cal2")
public class Calculator2 {
	
	public int addA(int a) {
		return a;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public String dddd(int a, int b) {
		return "결과 : " + (a + b);
	}

}
