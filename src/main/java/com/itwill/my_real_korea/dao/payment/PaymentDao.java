package com.itwill.my_real_korea.dao.payment;

import com.itwill.my_real_korea.dto.Payment;

import java.util.List;

public interface PaymentDao {

    //티켓 결제 생성
    int insertTicketPayment (Payment payment);
    //투어 결제 생성
    int insertTourPayment(Payment payment);

    // 내 결제 전체 보기
    List<Payment> selectAllUser(String userId);
    // 결제 상세 보기
    List<Payment> selectPaymentNo(int pNo);

    //결제 수정
    int updatePayment(Payment payment);
    //결제 삭제
    int deletePayment(int pNo);
}
