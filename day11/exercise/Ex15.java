package com.shinhan.day11.exercise;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// 12장 확인문제 15번
public class Ex15 {

	public static void main(String[] args) {
		// 올해 12월 31일까지 몇 일이 남았는지 구하는 코드
		LocalDateTime now = LocalDateTime.now(); // 현재 시간
		System.out.println("now : " + now);
		
		LocalDateTime endDateTime = LocalDateTime.of(now.getYear(), 12, 31, 0, 0, 0); // 올해 12월 31일
		System.out.println("end : " + endDateTime);
		
		if (now.isBefore(endDateTime)) {
			System.out.println("진행 중입니다.");
		} else if (now.isEqual(endDateTime)) {
			System.out.println("종료합니다.");
		} else if (now.isAfter(endDateTime)) {
			System.out.println("종료했습니다.");
		}
		
		long remainDay = now.until(endDateTime, ChronoUnit.DAYS);
		System.out.println("남은 일 : " + remainDay);
		
		long remainYear = now.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = now.until(endDateTime, ChronoUnit.MONTHS);
		long remainHour = now.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = now.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = now.until(endDateTime, ChronoUnit.SECONDS);
		System.out.println("남은 해 : " + remainYear);
		System.out.println("남은 달 : " + remainMonth);
		System.out.println("남은 시간 : " + remainHour);
		System.out.println("남은 분 : " + remainMinute);
		System.out.println("남은 초 : " + remainSecond);
	}

}
