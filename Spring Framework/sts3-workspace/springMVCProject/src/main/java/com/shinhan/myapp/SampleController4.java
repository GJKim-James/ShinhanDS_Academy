package com.shinhan.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinhan.myapp.vo.DeptDTO;

@Controller
public class SampleController4 {
	
	Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@GetMapping("/jsptest2/coffee.do")
	public void f1() {
		
	}
	
	// @RequestParam : request.getParameter("department_id")
	// 생략 가능
	@GetMapping("/jsptest2/coffee2.do")
	public void f2(@RequestParam int department_id, @RequestParam String department_name,
			@RequestParam int manager_id, @RequestParam int location_id) {
		logger.info("department_id : " + department_id);
		logger.info("department_name : " + department_name);
		logger.info("manager_id : " + manager_id);
		logger.info("location_id : " + location_id);
	}
	
	@GetMapping("/jsptest2/coffee3.do")
	// @ModelAttribute("deptDTO") ==> model.addAttribute("deptDTO", 값)
	public String f3(@ModelAttribute("deptDTO") DeptDTO deptDTO) {
		logger.info("deptDTO : " + deptDTO.toString());
		
		return "jsptest2/coffee2";
	}

}
