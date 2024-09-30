package com.shinhan.day01;

public class 형변환 {

	public static void main(String[] args) {
		typeTest();
		typeTest2();
		typeTest3();
		typeTest4();
		typeTest5();
		typeTest6();
		typeTest7();
	}

	private static void typeTest() {
		// 1. 자동 형 변환 : 큰 타입의 방 = 작은 값
		// 2. 강제 형 변환 : 작은 타입의 방 = (작은 타입) 큰 값
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		// 		   < char(2)
		byte var1 = 97;
		short var2 = 97; // short와 char는 자동 형 변환 불가능
		char var3 = 97; // a
		int var4 = 0;
		long var5 = 97;
		float var6 = 97;
		double var7 = 97;
		
		var4 = var1;
		var7 = var2;
		System.out.println("var4 = " + var4);
		System.out.println("var7 = " + var7);
		System.out.println("--------------------");
	}
	
	private static void typeTest2() {
		// 1. 자동 형 변환 : 큰 타입의 방 = 작은 값
		// 2. 강제 형 변환 : 작은 타입의 방 = (작은 타입) 큰 값 => 데이터 손실 가능성 있음
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		// 		   < char(2)
		byte var1;
		short var2 = 97; // short와 char는 자동 형 변환 불가능
		char var3 = 'a'; // a
		int var4 = 98;
		long var5;
		float var6;
		double var7;
		
		var1 = (byte) var3;
		var3 = (char) var4;
		System.out.println("var1 = " + var1);
		System.out.println("var3 = " + var3);
		System.out.println("--------------------");
	}
	
	private static void typeTest3() {
		byte a = 10, b = 20, c;
		// byte로 선언해도 수식에 있는 정수는 int로 자동 변형된다.
		c = (byte) (a + b);
		System.out.println("c = " + c);
		System.out.println("--------------------");
	}
	
	private static void typeTest4() {
		// 예외, char 타입보다 허용 범위가 작은 byte 타입은 char 타입으로 자동 변환될 수 없다.
		char c; // 2byte
		byte b = 97; // 1byte
		// 강제 변환
		c = (char) b;
		System.out.println("c = " + c);
		System.out.println("--------------------");
	}
	
	private static void typeTest5() {
		// char는 자바의 기본형 타입이다. 반드시 한 문자만 가능, 반드시 ''로 작성
		char ch = '자';
		// String은 자바의 class이다.
		// java.base 모듈 / java.lang 패키지 / String.class
		// 변경 불가능, 고정 문자열
		// 가변 문자열을 원한다면 StringBuffer, StringBuilder 사용해야함
		String s1 = "자바"; // 컴파일 시점에 객체 생성됨, 이미 존재하는 리터럴은 다시 생성 안함.
		String s2 = new String("자바"); // 실행 시점에 객체 생성됨
		String s3 = "자바";
		String s4 = new String("자바");
		String s5 = "이것이 \"자바\"다	'aaa'	\\	\"	\'	\r\n A\tB";
		String s6 = """
				이것이 "자바"다
				{"키":"값"}
				""";
		System.out.println(s5);
		System.out.println("--------------------");
		
		s1 = s1 + "!!"; // 위에 선언한 s1이 바뀐 것이 아닌 실제로는 새로운 주소에 만들어짐
		System.out.println("s1 == s3? " + (s1 == s3)); // 주소가 같은가? true
		System.out.println("s2 == s4? " + (s2 == s4)); // 주소가 같은가? false
		
		// 주소가 다른 것을 확인
		System.out.println("s1 주소값 : " + System.identityHashCode(s1));
		System.out.println("s3 주소값 : " + System.identityHashCode(s3));
		
		// 값 비교
		System.out.println("s1.equals(s3)? " + s1.equals(s3));
		System.out.println("--------------------");
	}
	
	private static void typeTest6() {
		int a = 10;
		int b = 3;
		
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b = " + (a / b));
		System.out.println("a % b = " + (a % b));
		System.out.println("a / b = " + (double) a / b);
		System.out.println("--------------------");
	}
	
	private static void typeTest7() {
		// String은 기본형이 아니라 객체이기 때문에 형 변환을 그냥 할 수 없다.
		/*
		 * 기본형 타입은 data 저장, 정수와 실수 타입은 연산 및 비교 가능
		 * Wrapper Class : 기본형 타입 + 기능 추가
		 * 1. byte => Byte
		 * 2. short => Short
		 * 3. char => Character	중요!
		 * 4. int => Integer	중요!
		 * 5. long => Long
		 * 6. float => Float
		 * 7. double => Double
		 * 8. boolean => Boolean
		 */
		// String.valueOf() 사용하여 형 변환
		String score = "99";
		int result = Integer.parseInt(score);
		long result2 = Long.parseLong(score);
		double result3 = Double.parseDouble(score);
		String b = "false";
		System.out.println("result + 1 : " + (result + 1)); // 100
		System.out.println("result2 + 1 : " + (result2 + 1)); // 100
		System.out.println("result3 + 1 : " + (result3 + 1)); // 100.0
		System.out.println("b == true? " + (Boolean.parseBoolean(b) == true));
		
		int score2 = 200;
		// 숫자를 문자로 바꾸기
		String score3 = score2 + "";
		String score4 = String.valueOf(score2);
		System.out.println(score3 + 1); // 2001
		System.out.println(score4 + 1); // 2001
		
		String str = "12.345";
		float f = Float.parseFloat(str);
		System.out.println(f + 10); // 22.345001
	}

}
