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

@WebServlet("/myPage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myPage GET 요청");
		
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("SS_USER_DTO");
		
		String userId = userDTO.getUser_id();
		
		UserService userService = new UserService();
		UserDTO resultDTO = userService.selectById(userId);
		
		request.setAttribute("resultDTO", resultDTO);
		request.getRequestDispatcher("jsp/user/userMyPage.jsp").forward(request, response);
	}

}
