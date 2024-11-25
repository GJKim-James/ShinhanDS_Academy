package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soccer.match.dto.MatchListDTO;
import soccer.match.dto.UserDTO;
import soccer.match.service.AdminService;
import soccer.match.service.UserService;

@WebServlet("/matchinsert.do")
public class MatchInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("matchinsert.do POST 요청");
		
		String match_date = request.getParameter("match_date"); // 2024-11-30T21:18
		match_date = match_date.split("T")[0] + " " + match_date.split("T")[1]; // 2024-11-30 21:25
		String match_place = request.getParameter("match_place");
		
		MatchListDTO matchListDTO = new MatchListDTO();
		matchListDTO.setMatch_date(match_date);
		matchListDTO.setMatch_place(match_place);
		
		AdminService adminService = new AdminService();
		int result = adminService.insertMatch(matchListDTO);
		
		String message = "";
		if (result == 1) {
			message = "경기 생성 성공";
		} else {
			message = "경기 생성 실패";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
