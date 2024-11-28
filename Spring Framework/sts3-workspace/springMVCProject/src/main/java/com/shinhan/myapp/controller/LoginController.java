package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.model.MemberService;
import com.shinhan.myapp.vo.MemberDTO;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login.do")
	public void loginPage() {
		// ��û URL�� JSP �̸��� �����ϱ� ������ return ��� �ȴ�.
	}
	
	@PostMapping("/login.do")
	public String loginPost(String userid, String userpw, HttpServletRequest request, HttpSession session) {
		// request ����غ���
		logger.info(request.getRemoteAddr() + "���� ��û��");
		
		MemberDTO memberDTO = memberService.loginService(userid, userpw);
		if (memberDTO == null) { // ���̵� �������� ����
			logger.info("���̵� �������� ����");
		} else if (memberDTO.getMember_id().equals("-1")) { // ��й�ȣ ����
			logger.info("��й�ȣ ����");
		} else { // �α��� ����
			// �α��� ���� ���ǿ� ����
			session.setAttribute("loginMember", memberDTO);
			
			// ���� ȭ��(�μ� ���)���� �̵�
			return "redirect:/dept/list.do";
		}
		
		// ���̵� �������� �ʰų� ��й�ȣ ������ ��� �ٽ� �α���
		return "redirect:/auth/login.do";
	}

}
