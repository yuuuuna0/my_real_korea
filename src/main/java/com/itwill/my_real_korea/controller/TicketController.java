package com.itwill.my_real_korea.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.payment.PaymentService;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketReviewService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;

@Controller
public class TicketController {

    private final TicketService ticketService;
    private final TicketImgService ticketImgService;
    private final TicketReviewService ticketReviewService;
    private final PaymentService paymentService;

    @Autowired
    public TicketController(TicketService ticketService, TicketImgService ticketImgService, TicketReviewService ticketReviewService,
                            CityService cityService, PaymentService paymentService) {
        this.ticketService = ticketService;
        this.ticketImgService = ticketImgService;
        this.ticketReviewService = ticketReviewService;
        this.paymentService = paymentService;
    }

    //티켓 리스트 - 페이지
    @GetMapping("/ticket-list")
    public String tickeList(@RequestParam(required = false, defaultValue = "1") int currentPage,Model model) {

        try {
            PageMakerDto<Ticket> ticketList = ticketService.selectAllTicket(currentPage);
            
            model.addAttribute("ticketList", ticketList.getItemList());
            model.addAttribute("currentPage", currentPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ticket-list";
    }

    //티켓 -- 상세보기 detail
    @GetMapping("/ticket-detail")
    public String ticketDetail(@RequestParam int tiNo, Model model, HttpSession session) {
        try {
        	
            List<Ticket> ticketList = ticketService.selectByTicketNoCityWithImg(tiNo);
            List<TicketReview> ticketReviewList = ticketReviewService.selectByTicketReviewNo(tiNo);
            model.addAttribute("ticketList", ticketList); // 티켓
            model.addAttribute("ticketReviewList",ticketReviewList); // 리뷰
            model.addAttribute("tiNo", tiNo);
            
            // 사진을 제외한 공통된 하나의 티켓 정보
            Ticket ticket = ticketList.get(0);
            // 세션에 티켓 정보 담기
            session.setAttribute("ticket", ticket);
        	// System.out.println(ticket);
        } catch(Exception e) {
        	e.printStackTrace();
        	return "redirect:error";
        }
        return "ticket-detail";
    }
   
    //티켓 상세 페이지에서 수량, 예약하기
    @LoginCheck
    @PostMapping("/ticket-detail-aciton") 
    public String ticketDetailPayment(@RequestParam String pStartDate, @RequestParam int pQty, HttpSession session) {
    	
    	Ticket ticket = (Ticket) session.getAttribute("ticket");
    	User user = (User) session.getAttribute("authUser"); // user 정보
    	System.out.println(user);
    	
    	try {
    		// 총 금액 = 수량 * 티켓 가격
    		int price = pQty* ticket.getTiPrice();
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		Date date = dateFormat.parse(pStartDate);
    		Payment payment = new Payment();
    		payment.setPPrice(price); // 총금액
    		payment.setPQty(pQty); // 수량
    		payment.setPPoint((int)(pQty * price * 0.1)); // 포인트 
    		payment.setPStartDate(date); // 예약날짜
    		payment.setUserId(user.getUserId());
    		session.setAttribute("payment", payment);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "redirect:error";
    	}
    	
    	return "ticket-payment";
    }
    
    
    //결제 상세 페이지
    @RequestMapping("/ticket-payment-complete-aciton") // 결제 성공
    public String ticketPaymentCompleteAction(HttpSession session) throws Exception {
    	
    		Payment payment = (Payment) session.getAttribute("payment");
    		//
            paymentService.insertTicketPayment(payment);

    		return "ticket-payment-confirmation";
    }



}


