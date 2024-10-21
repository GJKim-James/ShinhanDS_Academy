package com.shinhan.day11.exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

// 12장 확인문제 16번
public class Ex16 {

	public static void main(String[] args) {
		// 오늘 날짜를 괄호 안 형식처럼 출력
		Date now = new Date(); // 현재 시간(Mon Oct 21 17:32:09 KST 2024)
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		
		System.out.println(sdf.format(now));
	}

}
