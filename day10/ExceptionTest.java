package com.shinhan.day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	
	public static void main(String[] args) {
		// Stream : 1바이트씩 읽는다.(한글은 한 글자에 2바이트이기 때문에 깨져서 출력됨)
		// FileReader, Writer : 2바이트씩 읽는다.
		try (FileInputStream fi = new FileInputStream("src/com/shinhan/day10/Student.java")) {
			
			int i;
			while ((i = fi.read()) != -1) {
				System.out.print((char) i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("========== END ==========");
	}
	
	public static void main5(String[] args) {
		// 너무 지저분한 코딩
		FileInputStream fi = null;
		
		try {
			int a = 10 / 0;
			fi = new FileInputStream("src/com/shinhan/day10/Student.java");
			
			// 파일 읽기
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기 불가");
		} finally {
			// 자원 반납(File은 close 꼭 해줘야함, DB도 마찬가지)
			try {
				if (fi != null) {
					fi.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// Exception 처리하지 않고 떠넘기기(throws); 호출한 곳으로 이동
	public static void main4(String[] args) throws ClassNotFoundException {
		// 좋은 코딩이 아님, main3()가 좋은 코딩
		Class cls = Class.forName("com.shinhan.day10.Student2");
		System.out.println(cls.getModifiers());
		System.out.println(cls.getSimpleName());
		System.out.println("========== END ==========");
	}
	
	// Exception 처리함(try ~ catch ~ finally)
	public static void main3(String[] args) {
		// 메모리에 올리기
		try {
			Class cls = Class.forName("com.shinhan.day10.Student");
			
			System.out.println(cls.getModifiers());
			System.out.println(cls.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main2(String[] args) {
//		f1();
//		f2();
//		f3(0);
//		f4();
		try {
			f5();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음...파일 이름 확인 필요");
		} catch (IOException e) {
			System.out.println("입출력 오류(IOException)");
		}
		System.out.println("===== main method END(정상 종료) =====");
	}

	private static void f5() throws IOException {
		// 1. RuntimeException(예외 처리 필수 아님) - NumberFormatException, ArrayIndexOutOfBoundsException,
		//										  NullPointerException 등
		// 2. 일반 Exception(예외 처리 필수); 컴파일 시 Exception 처리가 되어있는지 체크한다.
		//    1) 내가 처리한다. 2) 떠넘긴다. : 함수의 선언부에 throws 키워드 사용(이 함수를 부른 곳으로 떠넘기기)
		FileReader fr = new FileReader("src/com/shinhan/day10/Student.java");
		
		// FileReader는 2바이트씩 읽는다.
		int i;
		while ((i = fr.read()) != -1) { // -1 : 끝을 의미
			System.out.print((char) i);
		}
		
		fr.close();
	}

	private static void f4() {
		// RuntimeException(예외 처리 필수 아님), 일반 Exception(예외 처리 필수)
		int a = 10;
		int[] arr = new int[5];
		String score = "100점";

		try {
			int iScore = Integer.parseInt(score);

			arr[5] = 100;
			arr[0] = 100;
			System.out.println(a / 0);
		} catch (NumberFormatException e) {
			System.out.println("반드시 숫자 형태의 문자열이어야 한다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("index 범위 벗어남");
		} catch (NullPointerException e) {
			System.out.println("null은 객체가 생성되지 않음을 의미; 사용 불가");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기 불가");
		} catch (Exception e) { // 다른 Exception을 포함하는 Exception은 맨 마지막에 위치해야 한다.
			System.out.println("기타 Exception");
		} finally {
			System.out.println("반드시 수행하는 문장들~");
		}

	}

	private static void f3(int b) {
		int a = 10;
//		int b = 0;

		// 예외가 발생하면?
		try {
			// 예외가 발생할 가능성이 있는 문장들을 작성
			System.out.println(a / b);
		} catch (Exception e) {
			// 예외 처리를 한다.
			System.out.println("정수는 0으로 나눌 수 없습니다");
			System.out.println("Exception Message : " + e.getMessage());
		} finally {
			System.out.println("finally는 예외 발생 또는 정상일 때 모두 수행");
		}
		System.out.println("===== f3() method END =====");
	}

	private static void f2() {
		int a = 10;
		int b = 0;

		if (b != 0) { // 예외가 발생하지 않도록 로직 수정; 오류 처리 로직과 업무 로직이 섞여있으므로 바람직하지 않은 코딩
			System.out.println(a / b);
		}

		System.out.println("===== f2() method END =====");
	}

	private static void f1() {
		// 프로그램은 실행하다가 오류가 날 수 있다. 그럼 프로그램은 중단된다.
		// Exception
		// 1) RuntimeException; 컴파일 시 Exception 처리 체크를 하지 않음, 예외 처리 필수가 아님
		// 2) 일반 Exception : 예외 처리 필수
		int a = 10;
		int b = 0;
		System.out.println(a / b); // 오류 발생(Exception) ... 프로그램 중단을 막을 수 있다.
		System.out.println("===== f1() method END =====");
	}

}
