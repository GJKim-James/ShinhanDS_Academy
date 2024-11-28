package com.shinhan.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shinhan.myapp.model.DeptService;
import com.shinhan.myapp.vo.DeptDTO;

// 부서의 CRUD 작업 : Controller -> Service -> DAO
// 사용자 요청 -> DispatcherServlet -> Controller 찾기
// component-scan에 의해서 Bean 생성
//@RestController // 요청을 받아서 응답 데이터를 return; @Controller + @ResponseBody
@Controller // 요청을 받아서 응답 페이지를 return
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	// 부서 목록 조회
//	@ResponseBody // Servlet에서 request.getWriter().append("aaa");와 같은 역할
	@RequestMapping("/dept/list.do")
	public String f1(Model model) {
		List<DeptDTO> deptList = deptService.selectAllService();
		
		model.addAttribute("deptList", deptList);
		
		return "dept/deptList"; // WEB-INF/views/dept/deptlist.jsp
	}
	
	// 부서 상세보기
	@GetMapping("/dept/detail.do")
	public String detail(int deptid, Model model) {
		model.addAttribute("deptDTO", deptService.selectById(deptid));
		
		return "dept/deptDetail";
	}
	
	// 상세보기 후 결과를 보여주고 1초 후 list로 가기
//	@PostMapping("/dept/detail.do")
//	public String detailPost(@ModelAttribute("deptDTO") DeptDTO deptDTO) {
//		logger.info(deptDTO.toString());
//		
//		// POST 방식은 한글 인코딩 필요 => web.xml Filter 등록 및 매핑
//		deptService.update(deptDTO);
//		
//		return "dept/result";
//	}
	
	// 부서 상세보기(POST)
	@PostMapping("/dept/detail.do")
	public String detailPost(DeptDTO deptDTO) {
		logger.info(deptDTO.toString());
		
		// POST 방식은 한글 인코딩 필요 => web.xml Filter 등록 및 매핑
		deptService.update(deptDTO);
		
		// 재요청하기(Servlet의 response.sendRedirect()와 동일한 역할)
		return "redirect:/dept/list.do";
	}
	
	// 부서 등록
	@GetMapping("/dept/insert.do")
	public String insert(DeptDTO deptDTO) {
		return "dept/deptInsert";
	}
	
	// 부서 등록(POST)
	@PostMapping("/dept/insert.do")
	public String insertPost(DeptDTO deptDTO) {
		deptService.insert(deptDTO);
		
		return "redirect:/dept/list.do";
	}
	
	// 부서 삭제
	@RequestMapping(value = "/dept/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int deptid) {
		deptService.delete(deptid);
		
		return "redirect:/dept/list.do";
	}

}
