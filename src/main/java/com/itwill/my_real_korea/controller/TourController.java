package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.RsPInfo;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.dto.user.User;

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
import com.itwill.my_real_korea.service.rspinfo.RsPInfoService;
import com.itwill.my_real_korea.service.tour.TourImgService;
import com.itwill.my_real_korea.service.tour.TourReviewService;
import com.itwill.my_real_korea.service.tour.TourService;
import com.itwill.my_real_korea.util.PageMakerDto;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TourController {
	private TourService tourService;
	private TourImgService tourImgService;
	private CityService cityService;
	private TourReviewService tourReviewService;
	private PaymentService paymentService;
	private RsPInfoService rsPInfoService;

	@Autowired
	public TourController(TourService tourService, TourImgService tourImgService, CityService cityService,TourReviewService tourReviewService,PaymentService payService,RsPInfoService rsPInfoService) {
		this.tourService=tourService;
		this.tourImgService=tourImgService;
		this.cityService=cityService;
		this.tourReviewService=tourReviewService;
		this.paymentService=payService;
		this.rsPInfoService=rsPInfoService;
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
			PageMakerDto<Tour> tourListPage=tourService.findAll(currentPage,keyword,cityNo,toType,sortOrder);
			List<Tour> tempTourList=tourListPage.getItemList();	//PageMakerDto -> List로 변환
			List<Tour> tourList=new ArrayList<>();
			//평점 평균 구하기
			for (Tour tour : tempTourList) {
				int tourScore=tourReviewService.calculateTourScore(tour.getToNo());
				tour.setToScore(tourScore);
				tourList.add(tour);	//tourList에 후기 평점 평균 붙이기
			}
			List<City> cityList=cityService.findAllCity();
			model.addAttribute("cityList", cityList);
			model.addAttribute("tourList",tourList);
			forwardPath="tour-list";
		} catch (Exception e){
			e.printStackTrace();
			forwardPath="error";
		}
		return forwardPath;
	}

	//2. 투어상품 상세보기
	@RequestMapping(value="/tour-detail", params = "toNo")
	public String tourDetail(@RequestParam int toNo, Model model) {
		String forwardPath="";
		try{
			Tour tour = tourService.findTourWithCityByToNo(toNo);
			if(tour!=null){
				int tourScore=tourReviewService.calculateTourScore(toNo);
				tour.setToScore(tourScore);
				model.addAttribute("tour",tour);
				forwardPath="tour-detail";
			} else{
				forwardPath="error";
			}
			List<TourReview> tourReviewList=tourReviewService.findByToNo(toNo);
			
			model.addAttribute("tourReviewList", tourReviewList);
		} catch (Exception e){
			e.printStackTrace();
			forwardPath="error";
		}
		return forwardPath;
	}

	
	//3. 투어상품 예약하기(구매하기) 폼_session 이용 x(성공) ----> 모델? 세션? 어느 코드가 나을까?
	@LoginCheck
 	@RequestMapping(value="/tour-payment")
	public String tourPaymentForm(@RequestParam String pStartDate,
								  @RequestParam int pQty,
								  @RequestParam int toNo,
								  HttpSession session,
								  Model model) {

		String forwardPath="";		
		try {
			Tour tour=tourService.findTourWithCityByToNo(toNo);
			User loginUser=(User)session.getAttribute("loginUser");
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			Date date=dateFormat.parse(pStartDate);
			System.out.println(date);
			Payment payment=new Payment(0, pQty*(tour.getToPrice()), pQty, new Date(), date, null, pQty*(tour.getToPrice())*1/100, 0, tour, null, loginUser.getUserId());
			//1. session에 붙이기
			session.setAttribute("payment", payment);
			session.setAttribute("tour", tour);
			//2. model에 붙이기
			//model.addAttribute("payment",payment);
			forwardPath="tour-payment";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="error";
		}

		return forwardPath;
	}

 
	//3-1. 투어상품 예약하기(구매하기) 액션
 	@LoginCheck
	@RequestMapping(value="tour-payment-action")
	public String tourPaymentAction(@ModelAttribute RsPInfo rsPInfo,
									@RequestParam String pMsg,
									@RequestParam String pMethodStr,
									HttpSession session,
									RedirectAttributes redirectAttributes) {
		String forwardPath="";
		try {
			User loginUser=(User)session.getAttribute("loginUser");
			Payment payment=(Payment)session.getAttribute("payment");
			Tour tour=(Tour)session.getAttribute("tour");
			payment.setPMsg(pMsg);
			int pMethod=Integer.parseInt(pMethodStr);
			payment.setPMethod(pMethod);
			
			paymentService.insertTourPayment(payment);
			tour.setToCount(tour.getToCount()+payment.getPQty());	//tour에 구매수량만큼 올리기
			tourService.updateTour(tour);
			Tour updatedTour=tourService.findTourWithCityByToNo(tour.getToNo());
			Payment findPayment=paymentService.findLatestPaymentByUserId(loginUser.getUserId());
			findPayment.setTour(updatedTour);
			rsPInfo.setPNo(findPayment.getPNo());
			rsPInfo.setUserId(loginUser.getUserId());
			rsPInfoService.insertRsPerson(rsPInfo);
			redirectAttributes.addFlashAttribute("payment",findPayment);
			redirectAttributes.addFlashAttribute("rsPInfo",rsPInfo);
			session.removeAttribute("payment");
			session.removeAttribute("tour");
			forwardPath="redirect:tour-payment-confirmation";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="error";
		}
		return forwardPath;
	}
	//4. 예약한 투어상품 상세 확인
	@RequestMapping(value="tour-payment-confirmation")
	public String tourPaymentConfirmation(@ModelAttribute Payment payment,
										  @ModelAttribute RsPInfo rsPInfo,
										  Model model) {
		String forwardPath="";
		
		model.addAttribute(payment);
		model.addAttribute(rsPInfo);
		System.out.println(payment);	//DB애 to_no는 있는데 tour가 안붙어나옴,,,
		System.out.println(rsPInfo);
		forwardPath="tour-payment-confirmation";
		return forwardPath;
	}
  	
}



/*
//2-1. 투어상품 상세보기 액션
@RequestMapping(value="tour-detail-action")
public String tourDetailAction(@RequestParam String pStarDate, 
								 @RequestParam int pQty,
								 @RequestParam int toNo,
								 RedirectAttributes redirectAttributes) {
	String forwardPath="";
//	redirectAttributes.addAttribute("pStartDate",pStarDate);
//	redirectAttributes.addAttribute("pQty",pQty);
//	redirectAttributes.addAttribute("toNo", toNo);
	forwardPath="redirect:tour-payment";
	return forwardPath;
}
*/
/*	
//3. 투어상품 예약하기(구매하기) 폼_session 이용 O (실패)
@RequestMapping(value="/tour-payment")
public String tourPaymentForm(HttpSession session,
							  @RequestParam String pStartDate,
							  @RequestParam int pQty,
							  @RequestParam int toNo) {
	String forwardPath="";
	try {
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date date=dateFormat.parse(pStartDate);
		Tour tour=tourService.findTourWithCityByToNo(toNo);
		Payment payment=(Payment)session.getAttribute("payment");
		if(payment==null) {
			session.setAttribute("payment", new Payment(0, 0, pQty, null, date, null, 0, 0, tour, null, null));
		}
		//payment.setPStartDate(null);
		//System.out.println(pStartDate);
		//System.out.println(pQty);
		payment.setPQty(pQty);
		payment.setTour(tour);
		payment.setPStartDate(date);
	}catch (Exception e) {
		e.printStackTrace();
		forwardPath="redirect:error";
	}
	return forwardPath;
}
*/
