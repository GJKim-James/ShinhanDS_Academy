package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogoutServlet
 */
@WebServlet("/userlogout")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 삭제 => 로그아웃
		
		String message = "로그아웃 되었습니다.";
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
