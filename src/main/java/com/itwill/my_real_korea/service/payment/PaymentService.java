package com.itwill.my_real_korea.service.payment;

import java.util.List;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.RsPInfo;

public interface PaymentService {
	
	//1-1. 티켓주문하기 (예약하기)
	int insertTicketPayment(Payment payment) throws Exception;
	//1-2. 티켓주문하기 (예약하기)
	int insertTourPayment(Payment payment) throws Exception;

    // 내 결제 전체 보기
    List<Payment> selectAllUser(String userId);
    // 결제 상세 보기
    Payment selectPaymentNo(int pNo);

    //결제 수정
    int updatePayment(Payment payment);
    //결제 삭제
    int deletePayment(int pNo);
    

    //사용자의 가장 최근 주문 조회하기
    Payment findLatestPaymentByUserId(String userId);

}
