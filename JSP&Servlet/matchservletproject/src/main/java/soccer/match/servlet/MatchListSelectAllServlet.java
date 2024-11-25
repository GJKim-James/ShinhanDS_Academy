package soccer.match.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.dto.MatchListDTO;
import soccer.match.service.AdminService;

@WebServlet("/matchlist")
public class MatchListSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("matchlist GET 요청");
		
		AdminService adminService = new AdminService();
		List<MatchListDTO> matchList = adminService.selectAll();
		
		request.setAttribute("matchList", matchList);
		request.getRequestDispatcher("jsp/admin/matchListSelectAll.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
