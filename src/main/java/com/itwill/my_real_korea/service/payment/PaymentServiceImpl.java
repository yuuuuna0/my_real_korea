package com.itwill.my_real_korea.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.payment.PaymentDao;
import com.itwill.my_real_korea.dao.rspinfo.RsPInfoDao;
import com.itwill.my_real_korea.dao.tour.TourDao;
import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.RsPInfo;

@Service
public class PaymentServiceImpl implements PaymentService{

	
	private PaymentDao paymentDao;
	private TourDao tourDao; 
	
	@Autowired
	public PaymentServiceImpl(PaymentDao paymentDao,TourDao tourDao) {
		this.paymentDao = paymentDao;
		this.tourDao=tourDao;
	}
	
	@Override
	public int insertTicketPayment(Payment payment) throws Exception{
		//티켓주문하기 (예약하기)
		
		
		
		return paymentDao.insertTicketPayment(payment);
	}
	
	@Override
	public int insertTourPayment(Payment payment) throws Exception{
		//투어주문하기 (예약하기)
		
		return paymentDao.insertTourPayment(payment);
	}

	@Override
	public List<Payment> selectAllUser(String userId) {
		return paymentDao.selectAllUser(userId);
	}

	@Override
	public Payment selectPaymentNo(int pNo) {
		return paymentDao.selectPaymentNo(pNo);
	}

	@Override
	public int updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}

	@Override
	public int deletePayment(int pNo) {
		return paymentDao.deletePayment(pNo);
	}

	@Override
	public Payment findLatestPaymentByUserId(String userId) {
		return paymentDao.findLatestPaymentByUserId(userId);
	}
	
}
