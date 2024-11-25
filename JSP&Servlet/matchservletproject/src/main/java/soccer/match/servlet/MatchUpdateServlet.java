package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.match.dto.MatchListDTO;
import soccer.match.service.AdminService;

@WebServlet("/matchupdate.do")
public class MatchUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("matchupdate.do GET 요청");
		
		int match_no = Integer.parseInt(request.getParameter("match_no"));
		String match_date = request.getParameter("match_date"); // 2024-11-30T21:18
		match_date = match_date.split("T")[0] + " " + match_date.split("T")[1]; // 2024-11-30 21:25
		String match_place = request.getParameter("match_place");
		int match_close = Integer.parseInt(request.getParameter("match_close"));
		int match_price = Integer.parseInt(request.getParameter("match_price"));
		int head_count = Integer.parseInt(request.getParameter("head_count"));
		
		MatchListDTO matchListDTO = new MatchListDTO().builder()
				.match_date(match_date)
				.match_place(match_place)
				.match_close(match_close)
				.match_price(match_price)
				.head_count(head_count)
				.match_no(match_no)
				.build();
		
		AdminService adminService = new AdminService();
		int result = adminService.updateMatchList(matchListDTO);
		
		String message = "";
		if (result == 1) {
			message = "경기 정보를 수정했습니다.";
		} else {
			message = "경기 정보 수정을 실패했습니다.";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
