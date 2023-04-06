package com.itwill.my_real_korea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	
	// 메인 페이지 
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// 에러 페이지 
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
