package com.shinhan.day13.exercise;

import java.util.TreeSet;

// 15장 확인문제 10번
public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Student2> treeSet = new TreeSet<>();
		
		treeSet.add(new Student2("blue", 96));
		treeSet.add(new Student2("hong", 86));
		treeSet.add(new Student2("white", 92));
		
		// Student2 클래스에서 정렬(비교)을 먼저 해줘야함.
		Student2 student = treeSet.last(); // last() : 가장 높은 score 리턴
		System.out.println("최고 점수: " + student.score);
		System.out.println("최고 점수를 받은 아이디: " + student.id);
	}

}
