package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.service.payment.PaymentService;

@RestController
public class PaymentRestController {
	private PaymentService paymentService;
	
	public PaymentRestController(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	//1. 구매상품 삭제
	@LoginCheck
	@DeleteMapping(value="/payment-delete/{pNo}", produces="application/json;charset=UTF-8")
	public Map<String, Object> paymentDelete(@PathVariable int pNo,HttpSession session) {
		Map<String, Object> resultMap=new HashMap<>();
		int code=0;
		String msg="";
		List<Payment> data=new ArrayList<>();
		User loginUser=(User)session.getAttribute("loginUser");
		try {
			paymentService.deletePayment(pNo);
			List<Payment> paymentList=paymentService.selectAllUser(loginUser.getUserId());
			data=paymentList;
			code=1;
			msg="성공";
		}catch (Exception e) {
			e.printStackTrace();
			code=2;
			msg="실패";
		}
		resultMap.put("data",data);
		resultMap.put("code",code);
		resultMap.put("msg", msg);
		return resultMap;
	}
	
}
