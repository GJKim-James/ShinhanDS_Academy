package com.shinhan.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;
import com.shinhan.myapp.job.JobService;
import com.shinhan.myapp.model.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp")
@Slf4j
@RequiredArgsConstructor // final로 선언된 변수 @Autowired
public class EmpController {
	
//	@Autowired
//	EmpService empService;
//	
//	@Autowired
//	JobService jobService;
//	
//	@Autowired
//	DeptService deptService;
	
	// final : 생성 시 
	final EmpService empService;
	final JobService jobService;
	final DeptService deptService;
	
	// 직원 목록 조회
	@GetMapping("/list.do")
	public String selectAll(Model model, HttpServletRequest request) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			String message = (String) map.get("resultMessage");
			log.info("[받은 메시지] : " + message);
			model.addAttribute("result", message);
		}
		
		model.addAttribute("jobList", jobService.selectAllJobs());
		model.addAttribute("deptList", deptService.selectAllService());
		
		return "emp/empList";
	}
	
	// empList 조건 조회 ajax 처리
	@GetMapping("/list2.do")
	public String selectByCondition(@RequestParam Map<String, Object> map, Model model) {
		log.info("map : " + map);
		
		// 모든 일자 체크 시 'hiredate=1900-01-01'로 설정
		String chkdate = (String) map.get("chkdate");
		if (chkdate.equals("true")) {
			map.put("hiredate", "1900-01-01");
		}
		
		List<EmpDTO> empList = empService.selectByCondition(map);
		log.info("조회된 empList 건수 : " + empList.size());
		model.addAttribute("empList", empList);
		
		// ajax 결과 보여줄 jsp
		return "emp/empListTable";
	}
	
	// 직원 등록
	@GetMapping("/insert.do")
	public String insert(Model model) {
		model.addAttribute("jobList", jobService.selectAllJobs());
		model.addAttribute("empList", empService.selectAllService());
		model.addAttribute("deptList", deptService.selectAllService());
		
		return "emp/empInsert";
	}
	
	// 직원 등록 POST
	@PostMapping("/insert.do")
	public String insertPost(EmpDTO empDTO, RedirectAttributes reAttr) {
		int result = empService.insertService(empDTO);
		
		String message = "입력 건수 : " + result;
		log.info(message);
		reAttr.addFlashAttribute("resultMessage", message);
		
		return "redirect:list.do";
	}
	
	// 직원 상세보기
	@GetMapping("/detail.do")
	public String detail(int empid, Model model) {
		EmpDTO empDTO = empService.selectByIdService(empid);
		
		model.addAttribute("empDTO", empDTO);
		model.addAttribute("jobList", jobService.selectAllJobs());
		model.addAttribute("empList", empService.selectAllService());
		model.addAttribute("deptList", deptService.selectAllService());
		
		return "emp/empDetail";
	}
	
	// 직원 정보 수정
	@PostMapping("/detail.do")
	public String detailPost(EmpDTO empDTO, RedirectAttributes reAttr) {
		int result = empService.updateService(empDTO);
		
		String message = "수정 건수 : " + result;
		log.info(message);
		reAttr.addFlashAttribute("resultMessage", message);
		
		return "redirect:list.do";
	}
	
	// 직원 삭제
	@GetMapping("/delete.do")
	public String delete(int empid, RedirectAttributes reAttr) {
		int result = empService.deleteService(empid);
		
		String message = "삭제 건수 : " + result;
		log.info(message);
		reAttr.addFlashAttribute("resultMessage", message);
		
		return "redirect:list.do";
	}
	
	// 직원 삭제 POST
	@PostMapping("/delete.do")
	public String deletePost(int empid, RedirectAttributes reAttr) {
		int result = empService.deleteService(empid);
		
		String message = "삭제 건수 : " + result;
		log.info(message);
		reAttr.addFlashAttribute("resultMessage", message);
		
		return "redirect:list.do";
	}

}
