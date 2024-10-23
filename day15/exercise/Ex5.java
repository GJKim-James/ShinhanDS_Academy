package com.shinhan.day15.exercise;

import java.util.Arrays;
import java.util.List;

// 17장 확인문제 5번
public class Ex5 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"This is a java book",
				"Lambda Expressions",
				"Java8 supports lambda expressions");
		
		list.stream().filter(s -> s.toLowerCase().contains("java")).forEach(s -> System.out.println(s));
	}

}
