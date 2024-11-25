package soccer.match.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.dto.MatchListDTO;
import soccer.match.service.UserService;

@WebServlet("/availableMatchList")
public class MatchListAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 신청 가능한 경기 목록 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("availableMatchList GET 요청");
		
		UserService userService = new UserService();
		List<MatchListDTO> matchList = userService.selectAvailableMatch();
		
		request.setAttribute("matchList", matchList);
		request.getRequestDispatcher("jsp/admin/matchListSelectAll.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("availableMatchList POST 요청");
	}

}
