package com.itwill.my_real_korea.dao.payment;

import com.itwill.my_real_korea.dao.ticket.TicketDao;
import com.itwill.my_real_korea.dao.ticket.TicketImgDao;
import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class PaymentDaoImplTest {

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    TicketDao ticketDao;

    @Test
    void insertPayment() {
        paymentDao.insertPayment(new Payment(
                0,10000,3,null,new Date(),"테스트인데요",0, 1,
                new Tour(1,null,0,0,0,null,0,null,null,0,new City(1,null,0,0)),
                new Ticket(0,null,null,0,null,null,0,new City(0,null,0,0)),"user3"
        ));
    }

    @Test
    void selectAllUser() throws Exception{
        List<Payment> paymentList = paymentDao.selectAllUser("user1");
        System.out.println(paymentList);
    }

    @Test
    void selectPaymentNo() {
        List<Payment> paymentList = paymentDao.selectPaymentNo(1);
        System.out.println(paymentList);

        // System.out.println(paymentList);
    }

    @Test
    void deletePayment() {
    }
}