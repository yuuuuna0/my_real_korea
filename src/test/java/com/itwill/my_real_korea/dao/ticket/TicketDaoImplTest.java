package com.itwill.my_real_korea.dao.ticket;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TicketDaoImplTest{

    @Autowired
    private TicketDao ticketDao;
    @Test
    void insertTicket() throws Exception{
        int rowCount = ticketDao.insertTicket
                (new Ticket(0,"인서트",null,1111,"인포","유의사항",0,
                        new City(1,"이름",1,1)));
        assertEquals(rowCount,1);

    }

}