package soccer.match.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;

@WebServlet("/selectMyMatch")
public class UserSelectMyMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectMyMatch GET 요청");
		
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("SS_USER_DTO");
		
		UserService userService = new UserService();
		List<MatchInfoDTO> myMatchInfoList = userService.selectMyMatch(userDTO);
		
		request.setAttribute("myMatchInfoList", myMatchInfoList);
		request.getRequestDispatcher("jsp/user/userMyMatch.jsp").forward(request, response);
	}

}
