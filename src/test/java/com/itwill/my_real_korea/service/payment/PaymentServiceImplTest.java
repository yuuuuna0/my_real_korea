package com.itwill.my_real_korea.service.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import com.itwill.my_real_korea.dto.tour.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.service.tour.TourService;

@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class PaymentServiceImplTest {
	
	@Autowired
	PaymentService paymentService;
	@Autowired
	TicketService ticketService;
	@Autowired
	TourService tourService;

	@Test
	void testInsertPayment() throws Exception{
		
		Payment payment = new Payment();
		payment.setPNo(0);
		payment.setPQty(3);
		payment.setTicket(ticketService.selectTicketNo(1));
		payment.setPStartDate(new Date());
		payment.setPMsg("요청");
		payment.setPPoint(0);
		payment.setPMethod(1);
		payment.setPPrice(payment.getTicket().getTiPrice()*payment.getPQty());
		payment.setTour(new Tour());
		payment.setUserId("user1");
		assertEquals(paymentService.insertPayment(payment),1);
		System.out.println(payment);
	}

	@Test
	void testSelectAllUser() {
		List<Payment> paymentList = paymentService.selectAllUser("user1");
		System.out.println(paymentList);
	}

	@Test
	void testSelectPaymentNo() {
		List<Payment> paymentList = paymentService.selectPaymentNo(11);
		System.out.println(paymentList);
	}

	@Test
	void testDeletePayment() {
		assertEquals(paymentService.deletePayment(12),1);
	}

}
