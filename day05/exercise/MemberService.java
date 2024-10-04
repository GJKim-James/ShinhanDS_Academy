package com.shinhan.day05.exercise;

// 6장 확인문제 13번 ~ 15번
// Service : 업무 로직 작성
public class MemberService {

	boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("1234")) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean login(Member member) {
		if (member.id.equals("hong") && member.password.equals("1234")) {
			return true;
		} else {
			return false;
		}
	}

	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}

}
