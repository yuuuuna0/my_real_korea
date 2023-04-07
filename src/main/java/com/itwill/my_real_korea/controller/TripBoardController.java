package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.service.tripboard.TripBoardService;
import com.itwill.my_real_korea.util.PageMakerDto;

@Controller
public class TripBoardController {
	
	@Autowired
	private TripBoardService tripboardService;
	
	/*
	 * 동행 게시판 리스트 보기 
	 */
	@GetMapping(value = "/tripboard-list")
	public String tripboard_list(@RequestParam(required = false, defaultValue = "1")int pageNo, Model model) {
		
		try {
			PageMakerDto<TripBoard> tripBoardList = tripboardService.selectAllTb(pageNo);
			model.addAttribute("tripBoardList",tripBoardList);
			model.addAttribute("pageNo",pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tripboard-list";
	}
	
	/*
	 * 동행 게시판 1개 보기
	 */
	
	public String tripboard_detail(@RequestParam int tBoNo, Model model) {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null; 
	}
	
	
	/*
	 * 동행 게시판 쓰기 폼
	 */
	@AdminCheck
	@LoginCheck
	@GetMapping("/tripboard_write_form")
	public String tripboard_write_form(HttpServletRequest request) {
		
		String requestUrl = request.getHeader("Referer");
		
		request.getSession().setAttribute("requestUrl", requestUrl);
		
		return "tripboard_write_form";
		
	}
	
	
	
	/*
	 * 동행 게시판 수정 폼
	 */
	@AdminCheck
	@LoginCheck
	@GetMapping("/tripboard_modify_form")
	public String tripboard_modify_form(HttpServletRequest request) {
		
		String requestUrl = request.getHeader("Referer");
		
		request.getSession().setAttribute("requestUrl", requestUrl);
		
		return "tripboard_write_form";
		
	}
	

}
