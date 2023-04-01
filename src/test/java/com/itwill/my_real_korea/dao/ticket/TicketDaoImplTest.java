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
@MapperScan(basePackageClasses = TicketMapper.class)
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
    /*
    @Disabled
    @Test
    void selectAllTicket(int pageStart, int pageEnd) throws Exception {
        List<Ticket> ticketList = ticketDao.selectAllTicket(pageStart, pageEnd);
        assertEquals(ticketList.size(),1);
    }*/
    /*
    @Disabled
    @Test
    void selectByTicketCity() throws Exception {
        List<Ticket> ticketListCityList = ticketDao.selectByTicketCity(1);
        assertEquals(ticketListCityList.size(),3);
    }*/
    /*@Disabled
    @Test
    void selectByKeywordTicket() throws Exception {
        List<Ticket> ticketKeywordList = ticketDao.selectByKeywordTicket("서울");
        assertEquals(ticketKeywordList.size(), 1);
    }*/
    /*
    @Disabled
    @Test
    void selectByTicketPrice() throws Exception {
        List<Ticket> selectByTicketPrice = ticketDao.selectByTicketPrice("asc");
        System.out.println(selectByTicketPrice);
    }*/

    @Disabled
    @Test
    void selectByTicketNoCityWithImg() throws Exception{
        List<Ticket> ticketList = ticketDao.selectByTicketNoCityWithImg(1);
        System.out.println(ticketList);
    }

    @Test
    void selectTest() throws Exception{
        List<Ticket> ticketList = ticketDao.selectTest("서울",1,10,1,"desc");
        System.out.println(ticketList);
    }

}
