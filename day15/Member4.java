package com.shinhan.day15;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Member4 implements Serializable {
	private String name;
	private int age;
}
