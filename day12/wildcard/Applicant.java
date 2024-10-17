package com.shinhan.day12.wildcard;

import lombok.AllArgsConstructor;

// 와일드카드 타입 파라미터

@AllArgsConstructor
public class Applicant<T> {
	public T kind;
}
