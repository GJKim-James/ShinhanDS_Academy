package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;

@WebServlet("/userinsert.do")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userinsert GET 요청");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userinsert POST 요청");
		
		// 한글 인코딩(EncodingFilter로 수행)
//		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_gender = request.getParameter("gender");
		
		System.out.println("===== 회원 가입 정보 =====");
		System.out.println("user_id : " + user_id);
		System.out.println("user_pw : " + user_pw);
		System.out.println("user_name : " + user_name);
		System.out.println("user_gender : " + user_gender);
		System.out.println("=======================");
		
		UserDTO userDTO = new UserDTO().builder()
				.user_id(user_id)
				.user_pw(user_pw)
				.user_name(user_name)
				.user_gender(user_gender)
				.build();
		
		// DB 저장
		UserService userService = new UserService();
		int result = userService.insertUser(userDTO);
		
		String message = "";
		if (result == 1) {
			message = "회원가입이 완료되었습니다.";
		} else {
			message = "회원가입을 실패하였습니다.";
		}
		
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
