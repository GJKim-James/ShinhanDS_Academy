package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.member.MemberDTO;

@WebServlet("/deptlist.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 Member만 부서 정보를 볼 수 있다.
		// 세션은 브라우저 당 1개(1인)
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMember");
		if (memberDTO == null) {
			String path = getServletContext().getContextPath();
			response.sendRedirect(path + "/login.do");
			return;
		}

		DeptService deptService = new DeptService();
		List<DeptDTO> deptList = deptService.selectAll();
		System.out.println(request.getRemoteAddr() + " 접속, " + deptList.size() + "건 조회됨.");

		request.setAttribute("deptDatas", deptList);
		request.getRequestDispatcher("jsp/dept/deptList.jsp").forward(request, response);
	}

}
