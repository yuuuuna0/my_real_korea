package com.itwill.my_real_korea.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.ticket.TicketReview;
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
    //@LoginCheck
    @PostMapping("/ticket-detail-aciton") 
    public String ticketDatailPayment(@RequestParam String pStartDate,
    								  @RequestParam int pQty,
    								  /* @RequestParam int tiNo,*/
    								  HttpSession session)
    								throws Exception {
    	
    	Ticket ticket = (Ticket) session.getAttribute("ticket");
    	// 총 금액 = 수량 * 티켓 가격
    	int price = pQty* ticket.getTiPrice();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = dateFormat.parse(pStartDate);
    	Payment payment = new Payment();
    	payment.setPPrice(price); // 총금액
    	payment.setPQty(pQty); // 수량
    	payment.setPPoint((int)(pQty * price * 0.1)); // 포인트 
    	payment.setPStartDate(date); // 예약날짜
    	session.setAttribute("payment", payment);
    	
    	return "ticket-payment";
    }


    /*티켓 리스트 - 정렬 -> REST Controller로 옮기거임 - TEST는 완료.

    //키워드, 지역별 - 필터 + 가격순, 날짜별 정렬 - 화면에 어떻게 넘길 지 생각하기 ㅠ
    @ApiOperation(value = "티켓-필터-정렬")
    @GetMapping(value = "/ticket-list-sort", produces = "application/json;charset=UTF-8")
    public Map<String, Object> ticketList(@RequestParam int currentPage,
                                          String keyword, int cityNo, String sortOrder) {
        Map<String, Object> ticketMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        PageMakerDto<Ticket> ticketList = null;
        try {

                //필터링 ->  tiNoDESC : 최신 순 / tiPriASC, tiPriDESC : 가격 순

            ticketList = ticketService.selectByTicketAllSort(currentPage, keyword, cityNo, sortOrder);
            if (ticketList.getTotRecordCount() != 0 && ticketList != null) {
                code = 1;
                msg = "성공";
            } else {
                code = 2;
                msg = "검색 조건에 해당하는 티켓이 없습니다.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            code = 3;
            msg = "오류";
        }

        ticketMap.put("code", code);
        ticketMap.put("msg", msg);
        ticketMap.put("ticketList", ticketList);

        return ticketMap;
    }
    */
    
 

    //티켓 상세 페이지에서 수량, 예약하기
    //@LoginCheck
    @RequestMapping("/ticket-payment-complete-aciton")
    public String ticketPaymentCompleteAction(HttpSession session) {
    			
    	try {
    		Payment payment = (Payment)session.getAttribute("payment");
    		paymentService.insertTicketPayment(payment);
    		return "ticket-payment-confirmation";
    	} catch(Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    	
    }

   /*payment -- 총 가격 js
    @PostMapping("ticket-payment")
    public String ticketPaymentForm (HttpSession session, Model model){
        //여기에 담겨야함 --> ticket-detail-action 이 내용이?
        Ticket sTicket = (Ticket)session.getAttribute("sTicket");
        int pQty = (int) session.getAttribute("pQty");
        String pStartDate = (String) session.getAttribute("pStartDate");
        
        return "ticket-payment";
    }

    //티켓 예약(구매) - action
    @PostMapping("ticket-payment-action")
    public String ticketPaymentAction (@ModelAttribute Payment payment, HttpSession session, Model model) {
        try {
            Ticket ticket = (Ticket) session.getAttribute("ticket");
            payment.setTicket(ticket);
            paymentService.insertTicketPayment(payment);
            session.setAttribute("payment", payment);
            return "redirect:ticket-payment-confirmation";
        } catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    
    
    //RedirectAttributes
    
    

    //티켓 주문 상세 확인
    
    @GetMapping("ticket-payment-confirmation")
    public String ticketPaymentConfirmation(HttpSession session, @RequestParam int pNo) {
        String sUserId = (String) session.getAttribute("sUserId");
        if(sUserId!=null) {
            paymentService.selectPaymentNo(pNo);
            session.setAttribute("pNo", pNo); // 주문번호 

        }
        return "ticket-payment-confirmation"; // 상세보기?
    }

 */
 





}






