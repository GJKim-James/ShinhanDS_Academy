package soccer.match.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;

@WebServlet("/matchapply")
public class UserMatchApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 사용자만 경기를 신청할 수 있다. 세션은 브라우저 당 1개(1인)
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("SS_USER_DTO");
		if (userDTO == null) {
			String message = "로그인이 필요한 서비스입니다.";
			request.setAttribute("message", message);
			
			String contextPath = getServletContext().getContextPath();
			response.sendRedirect(contextPath + "/userlogin");
			return;
		}
		
		// 로그인한 사용자는 경기 신청 가능
		int match_no = Integer.parseInt(request.getParameter("match_no"));
		String match_date = request.getParameter("match_date");
		String match_place = request.getParameter("match_place");
		
		// 이미 신청한 경기인지 중복 확인
		UserService userService = new UserService();
		int dup_result = userService.selectDuplicateChk(match_no, userDTO);
		
		int result;
		String message = "";
		if (dup_result == 1) {
			message = "이미 신청한 경기입니다.";
		} else {
			MatchInfoDTO matchInfoDTO = new MatchInfoDTO().builder()
					.match_date(match_date)
					.match_place(match_place)
					.build();
			result = userService.applyMatch(match_no, userDTO, matchInfoDTO);
			
			if (result == 1) {
				message = "해당 경기를 신청했습니다.";
			} else {
				message = "해당 경기를 신청하지 못했습니다.";
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/redirect.jsp").forward(request, response);
	}

}
