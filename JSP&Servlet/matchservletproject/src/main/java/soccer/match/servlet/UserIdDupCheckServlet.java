package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.service.UserService;

@WebServlet("/useriddupcheck")
public class UserIdDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("useriddupcheck GET 요청");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("useriddupcheck POST 요청");
		
		String user_id = request.getParameter("user_id");
		
		UserService userService = new UserService();
		int result = userService.idDupCheck(user_id);
		
		response.getWriter().append(result + "");
	}

}
