package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("jsp/user/userLogin.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("=============== 로그인 정보 ===============");
		System.out.println("user_id : " + user_id);
		System.out.println("user_pw : " + user_pw);
		System.out.println("========================================");
		
		UserDTO userDTO = new UserDTO().builder()
				.user_id(user_id)
				.user_pw(user_pw)
				.build();
		
		// 로그인 수행
		UserService userService = new UserService();
		UserDTO resultDTO = userService.login(userDTO);
		
		if (resultDTO.getUser_id() != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("SS_USER_DTO", resultDTO);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
//			if (resultDTO.getUser_id().equals("admin")) { // 관리자로 로그인 시
//				request.getRequestDispatcher("jsp/admin/adminMainPage.jsp").forward(request, response);
//			} else { // 사용자로 로그인 시
//				request.getRequestDispatcher("jsp/user/userMainPage.jsp").forward(request, response);
//			}
		} else { // 로그인 실패 시
			String message = "아이디 또는 비밀번호를 잘못 입력하였습니다.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
		}
	}

}
