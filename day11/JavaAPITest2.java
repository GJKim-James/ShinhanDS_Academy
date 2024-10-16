package com.shinhan.day11;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shinhan.day10.Student;

public class JavaAPITest2 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
		method8();
	}

	// 리소스 경로 얻기
	private static void method8() throws IOException {
		Class cls = JavaAPITest2.class;
		URL url = cls.getResource("img/Ji_Lee.jpg");
		System.out.println(url.getPath());
		
//		InputStream is = cls.getResourceAsStream("img/Ji_Lee.jpg");
		InputStream is = cls.getResourceAsStream("img/문자열 연습.txt");
		int i;
		while ((i = is.read()) != -1) {
			System.out.print(i);
		}
	}

	private static void method7() {
		method6(CellPhone.class);
		System.out.println("----------------------------------------");
		method6(Student.class);
	}

	// 리플렉션 멤버 정보 얻기
	private static void method6(Class aa) {		
		Field[] arrField = aa.getDeclaredFields();
		for (Field field : arrField) {
			System.out.println(field.getName());
		}
	}

	private static void method5() {
		String email = """
				99999999999999999999999
				gjk0635@naver.com
				mmmmmmmmmmmmmmmmm
				zzilre1004@naver.com
				aaaaaaaaaa
				1111111111111
				""";
		String regExp = "(\\w+)@\\w+\\.\\w+";
		
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(email);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
		}
	}

	// 리플렉션 멤버 정보 얻기
	private static void method4() throws ClassNotFoundException {
		// 리플렉션 : 클래스의 메타 정보 얻기
		Class<?> cls1 = CellPhone.class;
		Class<?> cls2 = Class.forName("com.shinhan.day11.CellPhone");
		CellPhone phone = new CellPhone("ABC");
		Class<?> cls3 = phone.getClass();
		
		Constructor[] arr1 = cls1.getDeclaredConstructors();
		for (Constructor cons : arr1) {
			System.out.println(cons.getParameterCount());
			
			Class[] aa = cons.getParameterTypes();
			for (Class bb : aa) {
				System.out.println(bb.getName());
			}
			System.out.println("----------------------------------------");
		}
	}

	private static void method3() {
		String subject = "Java";
		String regExp1 = "^J\\w+[^ABC]$";
		
//		String 
	}

	// 정규표현식
	private static void method2() {
		String email = "gjk0635@naver.com";
		String regExp1 = "\\w+[@#]?\\w{5,}\\.\\w*";
		
		boolean result = Pattern.matches(regExp1, email);
		System.out.println(result);
	}

	// 정규표현식
	private static void method1() {
		String phoneNumber = "010-1234-5678";
		
		// 0, 1로 3자리 - 0부터 9까지 숫자로 3자리 or 4자리 - 0부터 9까지 숫자로 4자리
//		String regExp1 = "[01]{3}-[0-9]{3,4}-[0-9]{4}";
		// cf. \\ => \
		String regExp1 = "[01]{3}-\\d{3,4}-\\d{4}";
		
		boolean result = Pattern.matches(regExp1, phoneNumber);
		System.out.println("regExp1 result : " + result);
		
		String email = "gjk0635@naver.com";
		
		// [] : 선택
		// - : 범위
		// + : 1개 이상
		// * : 0개 이상
		// ? : 없음 또는 한 개
		// [0-9a-zA-Z] : \w; 한 개의 알파벳 또는 한 개의 숫자
		// () : 그룹
//		String regExp2 = "[0-9a-zA-Z]+";
		String regExp2 = "(\\w+)@(\\w+\\.\\w+)";
		result = Pattern.matches(regExp2, email);
		System.out.println("regExp2 result : " + result);
		
		Pattern pattern1 = Pattern.compile(regExp1);
		Matcher matcher1 = pattern1.matcher(email);
		
		while (matcher1.find()) {
			System.out.println("matcher1.group() : " + matcher1.group()); // 전체
			System.out.println("matcher1.group(1) : " + matcher1.group(1)); // 첫 번째 ()
			System.out.println("matcher1.group(2) : " + matcher1.group(2)); // 두 번째 ()
		}
		
		Pattern pattern2 = Pattern.compile(regExp2);
		Matcher matcher2 = pattern2.matcher(email);
		
		while (matcher1.find()) {
			System.out.println("matcher2.group() : " + matcher2.group()); // 전체
			System.out.println("matcher2.group(1) : " + matcher2.group(1)); // 첫 번째 ()
			System.out.println("matcher2.group(2) : " + matcher2.group(2)); // 두 번째 ()
		}
	}

}
