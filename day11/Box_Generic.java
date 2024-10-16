package com.shinhan.day11;

import lombok.ToString;

// <> : 제네릭(Generic), 제네릭스(여러 개일 때)
// 영문자 대문자 아무거나 사용 가능 ex) <T>, <t>, <A> 등
// 구체적인 타입은 사용 시 결정

@ToString
public class Box_Generic<T, A> {
	// field
	T content;
	A size;
	
	// constructor
	public Box_Generic() {
		
	}
	
	public Box_Generic(T content, A size) {
		super();
		this.content = content;
		this.size = size;
	}

	// Getter, Setter
	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public A getSize() {
		return size;
	}

	public void setSize(A size) {
		this.size = size;
	}
}
