package com.shinhan.day15.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 17장 확인문제 8번

class Member3 {
	private String name;
	private String job;

	public Member3(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "{name:" + name + ", job:" + job + "}";
	}
}

public class Ex8 {

	public static void main(String[] args) {
		List<Member3> list = Arrays.asList(
				new Member3("홍길동", "개발자"), 
				new Member3("김나리", "디자이너"),
				new Member3("신용권", "개발자"));

		Map<String, List<Member3>> groupingMap = list.stream().collect(Collectors.groupingBy(m -> m.getJob()));

		System.out.println("[개발자]");
		groupingMap.get("개발자").stream().forEach(m -> System.out.println(m));
		System.out.println();

		System.out.println("[디자이너]");
		groupingMap.get("디자이너").stream().forEach(m -> System.out.println(m));
	}

}
