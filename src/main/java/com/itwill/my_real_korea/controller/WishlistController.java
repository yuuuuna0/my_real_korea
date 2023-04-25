package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.ticket.TicketImg;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.tour.TourImgService;
import com.itwill.my_real_korea.service.wishlist.WishlistService;

@Controller
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	@Autowired
	private TourImgService  tourImgService;
	@Autowired
	private TicketImgService ticketImgService;
	
	
	// 위시리스트 리스트 + 티켓상품 + 투어상품 전체 보기 (위시리스트 첫화면) 
	@LoginCheck
	@GetMapping(value = "/wishlist")
	public String wishlist(HttpServletRequest request, HttpSession session, Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		List<Wishlist> wishlistList = wishlistService.selectAllWithTicketAndTour(loginUser.getUserId());
		
//		for(Wishlist wishlist : wishlistList) {
//			//위시리스트에 투어 이미지리스트 붙이기 
//			int toNo=wishlist.getTour().getToNo();
//			tourImgList=tourImgService.findTourImgList(toNo);
//			model.addAttribute("tourImgList", tourImgList);
//			//위시리스트에 티켓 이미지리스트 붙이기
//			int tiNo=wishlist.getTicket().getTiNo();
//			ticketImgList=ticketImgService.selectTicketImgList(tiNo);
//			model.addAttribute("ticketImgList", ticketImgList);
//		}
//		System.out.println("요기요기요기요기요"+wishlistList.get(0).getTour().getTourImgList());
		
//		for (Wishlist wishlist : wishlistList) {
//			List<TourImg> tourImgList = wishlist.getTourImgList() ;
//			List<TicketImg> ticketImgList = wishlist.getTicketImgList();
//			model.addAttribute("tourImgList", tourImgList);
//			model.addAttribute("ticketImgList", ticketImgList);
//		}
		for (Wishlist wishlist : wishlistList) {
			if(wishlist.getTour()!=null) {
				List<TourImg> tourImgList=tourImgService.findTourImgList(wishlist.getTour().getToNo());
				wishlist.setTourImgList(tourImgList);
			} else if(wishlist.getTicket()!=null) {
				List<TicketImg> ticketImgList=ticketImgService.selectTicketImgList(wishlist.getTicket().getTiNo());
				wishlist.setTicketImgList(ticketImgList);
			}
		}
		for (Wishlist wishlist : wishlistList) {
			System.out.println(wishlist);
		}
		model.addAttribute("wishlistList", wishlistList);
		model.addAttribute("loginUser", loginUser);
	
		return "wishlist";
	}
	
}
