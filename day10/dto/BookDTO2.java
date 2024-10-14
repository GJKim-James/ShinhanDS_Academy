package com.shinhan.day10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//DTO(Data Transfer Object)
//VO(Value Object)
//Beans(Java Beans -- Object)

//@ToString
//@Getter
//@Setter
//@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data // @NoArgsConstructor, @Getter, @Setter, @ToString, @EqualsAndHashCode 생성해줌
public class BookDTO2 {
	
	String title;
	int price;

}
