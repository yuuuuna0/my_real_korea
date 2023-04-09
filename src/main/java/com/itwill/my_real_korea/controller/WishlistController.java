package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.wishlist.WishlistService;

@Controller
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	// 위시리스트 리스트 + 티켓상품 + 투어상품 전체 보기 (위시리스트 첫화면) 
	@LoginCheck
	@GetMapping(value = "/wishlist")
	public String wishlist(HttpServletRequest request, HttpSession session, Model model) {
		
		/*
		 * Referer : HTTP 요청 헤더의 일종으로, 
		 * 			요청 보낸 페이지의 URL 의미
		 */
		//String requestUrl = request.getHeader("Referer");
		// session 에 요청 보낸 페이지의 URL 저장(관리자 아닐 경우 이전 페이지로 돌려보내기 위해)
		//request.getSession().setAttribute("requestUrl", requestUrl);
		
		String sUserId = (String)session.getAttribute("sUserId");
		List<Wishlist> wishlistList = wishlistService.selectAllWithTicketAndTour(sUserId);
		model.addAttribute("wishlistList", wishlistList);
		model.addAttribute("sUserId", sUserId);
	
		return "wishlist";
	}
	
}
