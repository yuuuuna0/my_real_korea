package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.tour.TourReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.payment.PaymentService;
import com.itwill.my_real_korea.service.tour.TourImgService;
import com.itwill.my_real_korea.service.tour.TourReviewService;
import com.itwill.my_real_korea.service.tour.TourService;
import com.itwill.my_real_korea.util.PageMakerDto;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.List;

@Controller
public class TourController {
	private TourService tourService;
	private TourImgService tourImgService;
	private CityService cityService;
	private TourReviewService tourReviewService;
	private PaymentService paymentService;

	@Autowired
	public TourController(TourService tourService, TourImgService tourImgService, CityService cityService,TourReviewService tourReviewService,PaymentService payService) {
		this.tourService=tourService;
		this.tourImgService=tourImgService;
		this.cityService=cityService;
		this.tourReviewService=tourReviewService;
		this.paymentService=payService;
	}

	//1. 투어상품 전체 리스트 보기
	@RequestMapping(value="/tour-list")
	public String tour_list(@RequestParam(required = false, defaultValue = "1") int currentPage,
							@RequestParam(required = false) String keyword,
							@RequestParam(required = false, defaultValue = "0") int cityNo,
							@RequestParam(required = false, defaultValue = "0") int toType,
							@RequestParam(required = false) String sortOrder,
								Model model) {
		String forwardPath="";
		String msg="";
		try{
			PageMakerDto<Tour> tourList=tourService.findAll(currentPage,keyword,cityNo,toType,sortOrder);
			model.addAttribute("tourList",tourList);
			forwardPath="tour-list";
			msg="성공";
		} catch (Exception e){
			e.printStackTrace();
			forwardPath="redirect:main";
			msg="관리자에게 문의하세요";
		}
		model.addAttribute("msg",msg);
		return forwardPath;
	}

	//2. 투어상품 상세보기
	@RequestMapping(value="/tour-detail", params = "toNo")
	public String tour_detail(@RequestParam int toNo, Model model) {
		String forwardPath="";
		String msg="";
		try{
			Tour tour = tourService.findTourWithCityByToNo(toNo);
			if(tour!=null){
				List<TourImg> tourImgList=tourImgService.findTourImgList(toNo);
				tour.setTourImgList(tourImgList);
				model.addAttribute("tour",tour);
				forwardPath="tour-detail";
				msg="성공";
			} else{
				msg="해당 투어제품은 존재하지 않습니다.";
				forwardPath="redirect:myrealkorea";
			}
			List<TourReview> tourReviewList=tourReviewService.findByToNo(toNo);
			model.addAttribute("tourReviewList", tourReviewList);
		} catch (Exception e){
			e.printStackTrace();
			msg="관리자에게 문의하세요";
			forwardPath="redirect:main";
			model.addAttribute("msg",msg);
		}
		return forwardPath;
	}
	
	//2-1. 투어상품 상세보기 액션
	@PostMapping(value="tour-detail-action")
	public String tour_detail_action(@RequestParam int pStarDate, @RequestParam int pQty, @ModelAttribute Tour tour,HttpSession session) {
		String forwardPath="";
		session.setAttribute("pStartDate",pStarDate);
		session.setAttribute("pQty",pQty);
		session.setAttribute("Tour", tour);
		forwardPath="redirect:tour-reserve";
		return forwardPath;
	}
	
	//3. 투어상품 예약하기(구매하기) 폼
	@RequestMapping(value="/tour-reserve")
	public String tour_reserve_form(HttpSession session,Model model) {
		String forwardPath="";
		
		Tour tour=(Tour)session.getAttribute("tour");
		int pQty=(int)session.getAttribute("pQty");
		Date pStartDate=(Date)session.getAttribute("pStartDate");
		model.addAttribute("tour", tour);
		model.addAttribute("pQty", pQty);
		model.addAttribute("pStartDate",pStartDate);
		
		forwardPath="tour-reserve";
		return forwardPath;
	}
	
	//3-1. 투어상품 예약하기(구매하기) 액션
	@PostMapping(value="tour-reserve-action")
	public String tour_reserve_form(@ModelAttribute Payment payment,HttpSession session,Model model) {
		String forwardPath="";
		String msg="";
		try {
			Tour tour=(Tour)session.getAttribute("tour");
			payment.setTour(tour);
			paymentService.insertTourPayment(payment);
			session.setAttribute("payment", payment);
			forwardPath="redirect:tour-confirmation";
		}catch (Exception e) {
			e.printStackTrace();
			msg="관리자에게 문의하세요";
			forwardPath="redirect:main";
		}
		model.addAttribute(msg);
		return forwardPath;
	}
	
	//4. 예약한 투어상품 상세 확인
	@RequestMapping(value="tour-confirmation")
	public String tour_confirmation(HttpSession session) {
		String forwardPath="";
		session.getAttribute("tour");
		session.getAttribute("payment");
		return forwardPath;
	}
}
