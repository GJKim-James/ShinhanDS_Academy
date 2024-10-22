package com.shinhan.day14.exercise;

// 16장 확인문제 8번

@FunctionalInterface
interface Function3<T> {
	public double apply(T t);
}

class Student {
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEnglishScore() {
		return englishScore;
	}
	
	public int getMathScore() {
		return mathScore;
	}
}

// 영어 평균 점수와 수학 평균 점수 계산하는 코드
public class Ex8 {
	
	private static Student[] students = {
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
	};
	
	private static double avg(Function3<Student> function) {
		int sum = 0;
		
		for (Student student : students) {
			sum += function.apply(student);
		}
		
		double avg = (double) sum / students.length;
		
		return avg;
	}

	public static void main(String[] args) {
		double englishAvg = avg( s -> s.getEnglishScore() );
		System.out.println("영어 평균 점수 : " + englishAvg);
		
		double mathAvg = avg( s -> s.getMathScore() );
		System.out.println("수학 평균 점수 : " + mathAvg);
	}

}
