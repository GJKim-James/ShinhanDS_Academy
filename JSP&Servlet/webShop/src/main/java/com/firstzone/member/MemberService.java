package com.firstzone.member;

// DAO : 업무 로직, DB에 CRUD
// Service : DB 무관한 업무 로직 ex) 비밀번호 암호화
public class MemberService {
	
	MemberDAO memberDAO = new MemberDAO();
	
	public MemberDTO loginService(String id, String pw) {
		return memberDAO.login(id, pw);
	}

}
