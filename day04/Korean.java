package com.shinhan.day04;

public class Korean {
	// 1. field : 변수 (값 저장)
	private String nation = "대한민국";
	private String name;
	private String ssn;
	
	// 2. constructor
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	// 3. 일반 함수 : getter(값 가져오기, 얻기), setter(값 설정, 바꾸기)
	
}
