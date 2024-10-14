package com.shinhan.day10;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pack1.A;
import pack2.B;

public class LibraryTest {

	public static void main(String[] args) throws ParseException, JsonMappingException, JsonProcessingException {
//		method1();
//		method2();
		method3();
	}

	// jackson 라이브러리 사용
	private static void method3() throws JsonMappingException, JsonProcessingException {
		String jsonStr = """
				{
					"name" : "홍길동",
					"score" : 99,
					"major" : "컴퓨터공학과"
				}
				""";
		
		ObjectMapper mapper = new ObjectMapper();
		Student st = mapper.readValue(jsonStr, Student.class);
		
		System.out.println("st : " + st);
	}

	// JSON 라이브러리 사용
	private static void method2() throws ParseException {
		// JSON(JavaScript Object Notation; JavaScript Object 형태의 문자열)
		// "{ }"
		String jsonStr = """
				{
					"name" : "홍길동",
					"score" : 99,
					"major" : "컴퓨터공학과"
				}
				""";
		
		JSONParser parser = new JSONParser();
		// 하위 = (하위) Object
		JSONObject obj = (JSONObject) parser.parse(jsonStr);
		System.out.println("JSON obj : " + obj);
		System.out.println("score : " + obj.get("score"));
		System.out.println("name : " + obj.get("name"));
		System.out.println("major : " + obj.get("major"));
		System.out.println("--------------------------------------------------");
		
		Student student = new Student();
		student.setMajor((String) obj.get("major"));
		student.setName((String) obj.get("name"));
		student.setScore((Long) obj.get("score"));
		System.out.println("student : " + student);
	}

	// my_lib 사용
	private static void method1() {
		A a = new A();
		a.method();
		B b = new B();
		b.method();
	}

}
