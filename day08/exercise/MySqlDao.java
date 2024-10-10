package com.shinhan.day08.exercise;

// 8장 확인문제 7번
public class MySqlDao implements DataAccessObject {
	
	String dbName = "MySql DB";

	@Override
	public void select() {
		System.out.println(dbName + "에서 검색");
	}

	@Override
	public void insert() {
		System.out.println(dbName + "에 삽입");
	}

	@Override
	public void update() {
		System.out.println(dbName + "를 수정");
	}

	@Override
	public void delete() {
		System.out.println(dbName + "에서 삭제");
	}

}
