package com.itwill.my_real_korea.dao.ticket;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.mapper.TicketMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TicketDaoImplTest {


    @Autowired
    private TicketDao ticketDao;

    @Test
    void insertTicket() throws Exception {
        int rowCount = ticketDao.insertTicket
                (new Ticket(0, "인서트", null, 1111, "인포", "유의사항", 0,
                        new City(1, "이름", 1, 1)));
        assertEquals(rowCount, 1);

    }

    @Test
    void selectAll() throws Exception {
        List<Ticket> ticketList = ticketDao.selectAll();
        assertEquals(ticketList.size(),4);
    }

    @Test
    void selectByTicketCity() throws Exception {
        List<Ticket> ticketListCityList = ticketDao.selectByTicketCity(1);
        assertEquals(ticketListCityList.size(),3);
    }

    /*
    쿼리 다시 짜야함
    @Test
    void selectByTicketNoCity() throws Exception{
        List<Ticket> ticketList = ticketDao.selectByTicketNoCity(1);
        assertNotEquals(ticketList.size(), 0);
    }
    */

    @Test
    void selectByKeywordTicket() throws Exception {
        List<Ticket> ticketKeywordList = ticketDao.selectByKeywordTicket("서울");
        assertEquals(ticketKeywordList.size(), 1);
    }

    @Test
    void selectByTicketPrice() throws Exception {
        List<Ticket> selectByTicketPrice = ticketDao.selectByTicketPrice("asc");
        System.out.println(selectByTicketPrice);
    }
}
