package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

@WebServlet("/json.do")
public class JsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deptInsert.jsp에서 ajax data "jsonInfo" 가져오기
		String json = request.getParameter("jsonInfo");
		System.out.println("json : " + json);
		
		int result = 0;
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			
			System.out.println("==================== JSONObject로 파싱 후 데이터 추출 ====================");
			// JSON(String) => JSONObject => String => Integer
			Integer deptid = Integer.parseInt((String) jsonObj.get("deptid"));
			String deptname = (String) jsonObj.get("deptname");
			Integer managerid = Integer.parseInt((String) jsonObj.get("managerid"));
			Integer locationid = Integer.parseInt((String) jsonObj.get("locationid"));
			
			DeptDTO deptDTO = new DeptDTO().builder()
					.dept_id(deptid)
					.dept_name(deptname)
					.manager_id(managerid)
					.location_id(locationid)
					.build();
			System.out.println("deptDTO : " + deptDTO);
			System.out.println("====================================================================");
			
			DeptService deptService = new DeptService();
			result = deptService.insert(deptDTO);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().append(result + "건 입력");
	}

}
