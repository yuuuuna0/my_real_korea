package com.itwill.my_real_korea.dao.payment;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao{

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentDaoImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

	@Override
	public int insertTicketPayment(Payment payment) {
		//1. 티켓주문하기 (예약하기)
		return paymentMapper.insertTicketPayment(payment);
	}
	@Override
	public int insertTourPayment(Payment payment) {
		//1. 티켓주문하기 (예약하기)
		return paymentMapper.insertTourPayment(payment);
	}

    // 결제 보기
    @Override
    public List<Payment> selectAllUser(String userId) {
        return paymentMapper.selectAllUser(userId);
    }

    // 결제(예약) 상세보기
    @Override
    public Payment selectPaymentNo(int pNo) {
        return paymentMapper.selectPaymentNo(pNo);
    }

    // 결제 수정
    @Override
    public int updatePayment(Payment payment) {
        return paymentMapper.updatePayment(payment);
    }

    //결제 삭제
    @Override
    public int deletePayment(int pNo) {
        return paymentMapper.deletePayment(pNo);
    }

    //사용자의 가장 최근 주문 조회하기
	@Override
	public Payment findLatestPaymentByUserId(String userId) {
		return paymentMapper.findLatestPaymentByUserId(userId);
	}
}
