package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.service.AdminService;

@WebServlet("/matchdelete")
public class MatchDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("matchdelete GET 요청");
		
		int match_no = Integer.parseInt(request.getParameter("match_no"));
		
		AdminService adminService = new AdminService();
		int result = adminService.deleteMatch(match_no);
		
		String message = "";
		if (result == 1) {
			message = "삭제되었습니다.";
		} else {
			message = "삭제 실패했습니다.";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
