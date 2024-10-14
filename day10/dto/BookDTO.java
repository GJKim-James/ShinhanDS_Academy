package com.shinhan.day10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object)
// VO(Value Object)
// Beans(Java Beans -- Object)

//@ToString
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class BookDTO {
//	
//	String title;
//	int price;
//
//}

// 어노테이션을 사용하지 않고 다른 방법
// constructor, getter, toString, equals 메소드를 자동 생성
public record BookDTO(String title, int price) {
	
}
