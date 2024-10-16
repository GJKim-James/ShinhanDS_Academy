package com.shinhan.day11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationExample {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class cls = PrintAnnotationService.class;
		Method[] declareMethods = cls.getDeclaredMethods();
		
		for (Method method : declareMethods) {
			// PrintAnnotation 얻기
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			
			System.out.println(method.getName());
			
			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
			
			// 메소드 호출
			method.invoke(new PrintAnnotationService());
			System.out.println();
		}
	}
	
	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			// number 속성값 얻기
			int number = printAnnotation.number();
			
			for (int i = 0; i < number; i++) {
				// value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}

}
