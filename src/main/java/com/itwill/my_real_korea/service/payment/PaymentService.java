package com.itwill.my_real_korea.service.payment;

import java.util.List;

import com.itwill.my_real_korea.dto.Payment;

public interface PaymentService {
	
	//1-1. 티켓주문하기 (예약하기)
	int insertTicketPayment(Payment payment) throws Exception;
	//1-2. 티켓주문하기 (예약하기)
	int insertTourPayment(Payment payment) throws Exception;

    // 내 결제 전체 보기
    List<Payment> selectAllUser(String userId);
    // 결제 상세 보기
    List<Payment> selectPaymentNo(int pNo);

    //결제 수정
    int updatePayment(Payment payment);
    //결제 삭제
    int deletePayment(int pNo);

}
