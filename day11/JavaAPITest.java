package com.shinhan.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.StringTokenizer;

import com.shinhan.day04.Calculator;
import com.shinhan.util.DateUtil;

public class JavaAPITest {

	public static void main(String[] args) {
//		f1();
//		f2();
		
//		System.exit(0); // 즉시 종료
		System.out.println("---------- Main End ----------");
		
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
//		f15();
//		f16();
		f17();
	}

	private static void f17() {
		SimpleDateFormat sdf = new SimpleDateFormat("오늘은 yyyy년 E요일");
		java.util.Date dt = new java.util.Date();
		String s = sdf.format(dt);
		System.out.println("s : " + s);
		
		String s1 = "2024-11-15";
		java.util.Date d1 = DateUtil.convertDate(s1);
		System.out.println("d1 : " + d1);
		
		String s2 = DateUtil.convertString(d1);
		System.out.println("s2(String) : " + s2);
		
		java.sql.Date d2 = DateUtil.convertSqlDate(d1);
		System.out.println("d2(java.sql.Date) : " + d2);
	}

	private static void f16() {
		java.util.Date d1 = new java.util.Date();
		System.out.println(d1);
		
		// M : 월, m : 분 주의!
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(d1);
		System.out.println(s);
		
		String s2 = "2024/11/15/";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d2;
		try {
			d2 = sdf2.parse(s2);
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void f15() {
		double a = 12345678.9;
		
		DecimalFormat df = new DecimalFormat("\u00A4###, ###, ###.0000");
//		DecimalFormat df = new DecimalFormat("000, 000, 000.0000");
		
		String result = df.format(a);
		System.out.println(result);
	}

	private static void f14() {
		LocalDateTime d1 = LocalDateTime.now();
		System.out.println(d1);
		
		String[] arr = d1.toString().split("T");
		System.out.println("일자 : " + arr[0]);
		System.out.println("시간 : " + arr[1]);
		
		LocalDateTime d2 = d1.plusHours(5);
		System.out.println(d2);
	}

	private static void f13() {
		double a = (int) (Math.random() * 45) + 1; // 1부터 45
		
		Random b = new Random(5);
		
		for (int i = 1; i < 6; i++) {
			int c = b.nextInt(45) + 1;
			System.out.println(c);
		}
	}

	private static void f12() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get((Calendar.MONTH) + 1));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String weekName = null;
		
		switch (week) {
		case Calendar.MONDAY -> { weekName = "월"; }
		case Calendar.TUESDAY -> { weekName = "화"; }
		case Calendar.WEDNESDAY -> { weekName = "수"; }
		case Calendar.THURSDAY -> { weekName = "목"; }
		case Calendar.FRIDAY -> { weekName = "금"; }
		case Calendar.SATURDAY -> { weekName = "토"; }
		case Calendar.SUNDAY -> { weekName = "일"; }
		}
		
		System.out.println(week + " : " + weekName);
	}

	private static void f11() {
		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date();
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}

	private static void f10() {
		double a = Math.ceil(5.1); // 올림
		double b = Math.floor(5.9); // 버림
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}

	private static void f9() {
		Integer a = 127;
		int b = 127;
		Integer c = 130;
		Integer d = 130;
		
		// AutoBoxing
		// Integer는 -128 ~ 127 byte 범위는 같은 주소
		System.out.println("a == b ? " + (a == b)); // 주소 같음
		System.out.println("c == d ? " + (c == d)); // 주소 다름
		
		System.out.println(a.equals(b) ? "내용 같음" : "내용 다름");
		System.out.println(c.equals(d) ? "내용 같음" : "내용 다름");
	}

	private static void f8() {
		// 기본형(8가지) : boolean, byte, short, char, int, long, float, double
		int score = 100;
		score = score + 99;
		System.out.println(score > 100);
		
		// Wrapper Class = 기본형 + 기능
//		Integer score2 = new Integer(100);
		Integer score2 = 100; // AutoBoxing 된다.
		
		score2 = score2.intValue(); // UnBoxing
		System.out.println("score2 : " + score2);
		
		score2 = score2 + 99;
		System.out.println(score2 > 100);
		// 기능 사용
		float f = score2.floatValue();
		
		String score3 = "100";
		int score4 = Integer.parseInt(score3) + 200; // AutoBoxing
		System.out.println("score4 : " + score4); // UnBoxing
		
		double score5 = Double.parseDouble(score3) + 300;
		System.out.println("score5 : " + score5);
	}

	private static void f7() {
		String names = "자바/Oracle-HTML/CSS#JavaScript Spring*Framework";
		
		StringTokenizer st = new StringTokenizer(names, "/-\\*# "); // | 없어도 된다.
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("----------------------------------------");
		
		StringTokenizer st2 = new StringTokenizer(names); // default 구분자는 공백
		
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	}

	private static void f6() {
		String names = "자바/Oracle-HTML/CSS#JavaScript Spring*Framework";
		
		// *는 정규표현식에서 '모든(All)'이라는 의미가 있다. 그래서 \\* 로 써줘야함
		// \* => *라는 문자의 의미
		// \\ => \
		// \\* => \* (* 문자라는 의미)
		String[] arr = names.split("/|-|\\*|#| "); // | 필수
		System.out.println(Arrays.toString(arr));
	}

	private static void f5() {
		// String : 고정 문자열
		// StringBuffer, StringBuilder : 가변 문자열
//		StringBuilder sb = "자바"; // 직접 대입 불가(new로 생성해야함)
		StringBuilder sb = new StringBuilder("자바");
//		sb = sb + "정복"; // 불가
		sb.append("' 정복(뒤에 추가)'");
		System.out.println("append : " + sb);
		sb.insert(0, "'앞 부분에 추가 가능 '");
		System.out.println("insert : " + sb);
		
		StringBuffer sb2 = new StringBuffer("자바");
		System.out.println(sb2);
	}

	// String의 단점
	private static void f4() {
		String s1 = "자바";
		String s2 = "자바";
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		String s3 = new String("자바");
		String s4 = new String("자바");
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		// String은 변경 불가; 변경이 아니고 새로운 주소가 생기는 것(메모리 낭비)
		s1 = s1 + "정복";
		s2 = s2 + "정복";
	}

	private static void f3() {
		// String
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		
		byte[] arr1 = { 97, 98, 99 }; // a, b, c
//		String s4 = new String(arr1);
		String s4 = call(arr1);
		System.out.println("byte[] arr1 : " + s4);
		
		char[] arr2 = { 'a', 'b', 'c' };
//		String s5 = new String(arr2);
		String s5 = call2(arr2);
		System.out.println("char[] arr2 : " + s5);
		System.out.println("----------------------------------------");
		
		// 문자를 byte로 변경하기 (1byte, 2byte; EUC-KR, 3byte; UTF-8)
		byte[] arr3 = s1.getBytes();
		System.out.println("'자바' 문자를 byte[]로 변경 : " + Arrays.toString(arr3));
		System.out.println("byte[]로 변경한 것을 다시 문자로 변경 : " + call(arr3));
		System.out.println("----------------------------------------");
		
		try {
			byte[] arr4 = s1.getBytes("EUC-KR"); // EUC-KR은 한 문자를 2byte로 인식
			System.out.println("'자바' 문자를 byte[]로 변경 : " + Arrays.toString(arr4));
			System.out.println("byte[]로 변경한 것을 다시 문자로 변경 : " + call(arr4)); // 깨짐
			System.out.println("byte[]로 변경한 것을 다시 문자로 변경 : " + call3(arr4, "EUC-KR"));
			System.out.println("----------------------------------------");
			
			byte[] arr5 = s1.getBytes("UTF-8"); // UTF-8은 한 문자를 3byte로 인식
			System.out.println("'자바' 문자를 byte[]로 변경 : " + Arrays.toString(arr5));
			System.out.println("byte[]로 변경한 것을 다시 문자로 변경 : " + call3(arr5, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("----- UnsupportedEncodingException -----");
			e.printStackTrace();
		}
	}
	
	private static String call3(byte[] arr4, String charset) throws UnsupportedEncodingException {
		return new String(arr4, charset);
	}

	private static String call2(char[] arr) {
		return new String(arr);
	}
	
	private static String call(byte[] arr) {
		return new String(arr);
	}

	private static void f2() {
//		long a = System.currentTimeMillis();
		long a = System.nanoTime();
		
		for (int i = 0; i < 100000; i++) {
			System.out.println(i);
		}
		
//		long b = System.currentTimeMillis();
		long b = System.nanoTime();
		
//		System.out.println((b - a) + "ms");
		System.out.println("nanoTime : " + (b - a) + "ns");
	}

	private static void f1() {
		// 표준 출력(기본 : 모니터)
		PrintStream a = System.out;
		a.println("---------- 표준 출력(기본 : 모니터) ----------");

		PrintStream a2 = System.err;
		a2.println("---------- 빨간색으로 표시 ----------");

		// 표준 입력(기본 : 키보드)
		InputStream is = System.in;

		// 1byte
		// IOExceptoin : Checked Exception 이므로 컴파일 시 check, 처리 or 던지기
		int n = 0;
		try {
			n = is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("n : " + (char) n);
	}

}
