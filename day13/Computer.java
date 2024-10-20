package com.shinhan.day13;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of = "model")
@ToString
@AllArgsConstructor
public class Computer implements Comparable<Computer> {
	
	String model;
	int price;
	
	@Override
	public int compareTo(Computer obj) {
		// asc : 앞에 현재 객체, 뒤에 들어온 객체
		int result = price - obj.price;
		
		if (result == 0) {
			// desc : 뒤에 들어온 객체, 앞에 현재 객체
			return obj.model.compareTo(model);
		}
		return result;
	}

}
