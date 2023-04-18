package com.itwill.my_real_korea.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.RsPInfo;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.service.payment.PaymentService;
import com.itwill.my_real_korea.service.rspinfo.RsPInfoService;
import com.itwill.my_real_korea.service.ticket.TicketReviewService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;

@Controller
public class TicketController {
	
    private final TicketService ticketService;
    private final TicketReviewService ticketReviewService;
    private final PaymentService paymentService;
    private final RsPInfoService rsPInfoService;

    @Autowired
    public TicketController(TicketService ticketService, TicketReviewService ticketReviewService,
    						RsPInfoService rsPInfoService, PaymentService paymentService) {
        this.ticketService = ticketService;
        this.ticketReviewService = ticketReviewService;
        this.paymentService = paymentService;
        this.rsPInfoService = rsPInfoService;
    }

    //티켓 리스트 - 페이지
    @GetMapping("/ticket-list")
    public String tickeList(@RequestParam(required = false, defaultValue = "1") int currentPage,
    						@ModelAttribute Payment payment, Model model) {
    	
        try {
            PageMakerDto<Ticket> ticketList = ticketService.selectAllTicket(currentPage);
            
            model.addAttribute("ticketList", ticketList.getItemList());
            model.addAttribute("currentPage", currentPage);
           // System.out.println(payment.getPQty());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ticket-list";
    }

    //티켓 -- 상세보기 detail
    @GetMapping("/ticket-detail")
    public String ticketDetail(@RequestParam int tiNo, Model model, HttpSession session) {
    	
    	String forwardPath = "";
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
            forwardPath = "ticket-detail";
        } catch(Exception e) {
        	e.printStackTrace();
        	forwardPath="redirect:error";
        }
        return forwardPath;
    }
   
    //티켓 상세 페이지에서 수량, 예약하기
    @PostMapping("/ticket-detail-aciton") 
    public String ticketDetailPayment(@RequestParam String pStartDate,
    									@RequestParam int pQty, HttpSession session) throws Exception{
    	String forwardPath = "";
    	Ticket ticket = (Ticket) session.getAttribute("ticket");
    	/* 세션으로 넣기 */
    	//String sUserId = (String) session.getAttribute("sUserId");
    	//User user = userService.findUser(sUserId);
    	User loginUser = (User) session.getAttribute("loginUser");
		session.setAttribute("loginUser", loginUser);
		
		
    	try {
    		//System.out.println(loginUser);
    		// 총 금액 = 수량 * 티켓 가격
    		int price = pQty* ticket.getTiPrice();
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		Date date = dateFormat.parse(pStartDate);
    		Payment payment = new Payment();
    		payment.setPPrice(price); // 총금액
    		payment.setPQty(pQty); // 수량
    		payment.setPPoint((int)(pQty * price * 0.1)); // 포인트 
    		payment.setPStartDate(date); // 예약날짜
    		payment.setUserId(loginUser.getUserId()); // user 담기
    		payment.setTicket(ticket); // 티켓 담기
    		
    		paymentService.insertTicketPayment(payment);
    		session.setAttribute("payment", payment);
    		System.out.println(payment); 
    		forwardPath="ticket-payment";
    	} catch (Exception e) {
    		e.printStackTrace();
    		forwardPath="redirect:error";
    	}
    	
    	return forwardPath;
    }
    
    //결제 상세 페이지 - action
    @PostMapping("/ticket-payment-complete-action") // 결제 성공  //default값 설정
    public String ticketPaymentCompleteAction(
        HttpSession session, 
        @ModelAttribute RsPInfo rsPInfo,
        @RequestParam(required = false, defaultValue = "") String pMsg,
        @RequestParam int pMethod, // ?
        RedirectAttributes redirectAttributes
    ) {
        String forwardPath = "";
        Payment payment = (Payment) session.getAttribute("payment");
        Ticket ticket = (Ticket) session.getAttribute("ticket");
        User loginUser = (User) session.getAttribute("loginUser");

        try {
        	  if (pMethod==1) {
	                payment.setPMethod(1);
	            } else if (pMethod==2) {
	            	 payment.setPMethod(2);
	            }
        	 // System.out.println(pMethodStr);
        	 // System.out.println(pMethodStr);
        	payment.setPMsg(pMsg);  
        	//payment.setPMethod(Integer.parseInt(pMethodStr));
            // paymentService.insertTicketPayment(payment);
        	paymentService.updatePayment(payment);
            ticket.setTiCount(ticket.getTiCount() + payment.getPQty());
            ticketService.updateTicket(ticket);

            Ticket updateTicket = ticketService.selectTicketNo(ticket.getTiNo());
            Payment selectPayment = paymentService.findLatestPaymentByUserId(loginUser.getUserId());
            selectPayment.setTicket(updateTicket);

            rsPInfo.setPNo(selectPayment.getPNo());
            rsPInfo.setUserId(loginUser.getUserId());
            rsPInfoService.insertRsPerson(rsPInfo);

            redirectAttributes.addFlashAttribute("payment", selectPayment);
            redirectAttributes.addFlashAttribute("rsPInfo", rsPInfo);

            session.removeAttribute("payment");
            session.removeAttribute("rsPInfo");

            forwardPath = "redirect:ticket-payment-confirmation";
        } catch(Exception e) {
            e.printStackTrace();
            forwardPath = "redirect:error";
        }

        return forwardPath;
    }

    @RequestMapping("/ticket-payment-confirmation")
    public String ticketPaymentRemove (@ModelAttribute Payment payment,
    									@ModelAttribute RsPInfo rsPInfo, 
    									Model model){
    	model.addAttribute(payment);
    	model.addAttribute(rsPInfo);
    	
    	System.out.println(payment.getPMethod());
    	return "ticket-payment-confirmation";
    }


    @PostMapping(value = "/ticket-list-sort", produces = "application/json;charset=UTF-8") //rest ? 
    @ResponseBody
    public Map<String, Object> ticketList(@RequestBody Map<String,String> map){
        Map<String, Object> ticketSortMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        List<Ticket> data = null;
        int currentPage = Integer.parseInt(map.get("currentPage"));
        int cityNo = Integer.parseInt(map.get("cityNo"));
        String keyword = map.get("keyword");
        String sortOrder = map.get("sortOrder");

        try {
            PageMakerDto<Ticket> ticketPage
                    = ticketService.selectByTicketAllSort(currentPage,keyword, cityNo, sortOrder);
            List<Ticket> tempTicketList = ticketPage.getItemList();
            List<Ticket> ticketList = new ArrayList<>();
            for(Ticket ticket : tempTicketList) {
                int ticketScore = ticketReviewService.calculateTourScore(ticket.getTiNo());
                ticket.setTiScore(ticketScore);
                ticketList.add(ticket);
            }
            data = ticketList;
            code = 1;
            msg = "성공";
        } catch (Exception e){
            e.printStackTrace();
            code = 2;
            msg = "관리자에게 문의하세요.";
        }
        ticketSortMap.put("code", code);
        ticketSortMap.put("msg", msg);
        ticketSortMap.put("data", data);
        return ticketSortMap;
    }

	@PostMapping("/ticket-review-action")
	@ResponseBody
	public Map<String, Object> ticketReviewAction(@RequestBody TicketReview ticketReview, int tiNo) {
		Map<String, Object> resultMap = new HashMap<>();
		int code = 0;
		String msg = "성공";
		
		List<TicketReview> data = null;
		try {
			ticketReviewService.insertTicketReview(ticketReview);
			data = ticketReviewService.selectByTicketReviewNo(tiNo);
			code=1;
			msg="성공";
			
		} catch (Exception e) {
			e.printStackTrace();
			code=2;
			msg="관리자에게 문의하세요";
		}
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	

}


