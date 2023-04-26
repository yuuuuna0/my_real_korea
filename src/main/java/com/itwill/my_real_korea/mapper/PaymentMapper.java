package com.itwill.my_real_korea.mapper;

import com.itwill.my_real_korea.dto.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

	//1-1. 티켓주문하기 (예약하기)
	int insertTicketPayment(Payment payment);
	//1-2. 투어주문하기 (예약하기)
	int insertTourPayment(Payment payment);

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
