package com.shinhan.day14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		Random random = new Random();

		List<Long> scores = new ArrayList<>();

		LongStream.rangeClosed(0, 100000000).forEach(i -> {
			scores.add(random.nextLong(101));
		});

		double avg = 0.0;
		double parallelAvg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;

		startTime = System.nanoTime();
		avg = scores.stream().mapToLong(i -> i.longValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns"); // 82,011,000ns
		System.out.println("----------------------------------------");
		
		startTime = System.nanoTime();
		parallelAvg = scores.parallelStream().mapToLong(i -> i.longValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("parallelAvg: " + parallelAvg + ", 병렬 스트림 처리 시간: " + time + "ns"); // 34,280,400ns
	}

	private static void f3() {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("홍길동", "남", 92));
		studentList.add(new Student("김수영", "여", 87));
		studentList.add(new Student("감자바", "남", 95));
		studentList.add(new Student("오해영", "여", 93));

		// 성별과 성별의 평균 점수 기준으로 그룹핑
		Map<String, Double> map = studentList.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(s -> s.getScore())));
		System.out.println(map);
	}

	// 요소 그룹핑
	private static void f2() {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("홍길동", "남", 92));
		studentList.add(new Student("김수영", "여", 87));
		studentList.add(new Student("감자바", "남", 95));
		studentList.add(new Student("오해영", "여", 93));
		studentList.add(new Student("김광진", "남", 100));

		// 성별 기준으로 그룹핑
		Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(s -> s.getGender()));

		List<Student> maleList = map.get("남");
		maleList.stream().forEach(s -> System.out.println(s));
		System.out.println("----------------------------------------");

		List<Student> femaleList = map.get("여");
		femaleList.stream().forEach(s -> System.out.println(s));
	}

	// 요소 수집
	private static void f1() {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("홍길동", "남", 92));
		studentList.add(new Student("김수영", "여", 87));
		studentList.add(new Student("감자바", "남", 95));
		studentList.add(new Student("오해영", "여", 93));
		studentList.add(new Student("김광진", "남", 100));

		studentList.stream().forEach(st -> System.out.println(st));
		System.out.println("----------------------------------------");

		// 남학생만 출력
		studentList.stream().filter(st -> st.getGender().equals("남")).forEach(st -> System.out.println(st));
		System.out.println("----------------------------------------");

		// 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
		Map<String, Integer> map = studentList.stream().filter(st -> st.getGender().equals("남"))
				.collect(Collectors.toMap(st -> st.getName(), st -> st.getScore()));
		System.out.println(map);
		System.out.println("----------------------------------------");

		// Set
		Set<Student> set = studentList.stream().filter(st -> st.getGender().equals("남")).collect(Collectors.toSet());
		System.out.println(set);
	}

}
