package com.itwill.my_real_korea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.RsPInfo;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.service.payment.PaymentService;
import com.itwill.my_real_korea.service.rspinfo.RsPInfoService;

@Controller
public class PaymentContoller {
	private PaymentService paymentService;
	private RsPInfoService rsPInfoService;
	
	public PaymentContoller(PaymentService paymentService, RsPInfoService rsPInfoService) {
		this.paymentService=paymentService;
		this.rsPInfoService=rsPInfoService;
	}
	
	//2. 구매내역 보기
	@LoginCheck
	@GetMapping(value="payment-detail")
	public String paymentDetail(@RequestParam int pNo,Model model){
		String forwardPath="";
		try {
			Payment payment=paymentService.selectPaymentNo(pNo);
			RsPInfo rsPInfo=rsPInfoService.selectRsPersonByPNo(pNo);
			model.addAttribute("RsPInfo",rsPInfo);
			model.addAttribute("payment",payment);
			if(payment.getTour()!=null) {
				//투어예약 상세보기
				Tour tour=payment.getTour();
				model.addAttribute("tour",tour);
				forwardPath="tour-payment-confirmation";
			} else if(payment.getTicket()!=null){
				//티켓예약 상세보기
				forwardPath="ticket-payment-confirmation";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return forwardPath;
	}
	
}
