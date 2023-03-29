package com.itwill.my_real_korea.dao.ticket;

import com.itwill.my_real_korea.dto.ticket.TicketImg;
import com.itwill.my_real_korea.mapper.TicketMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TicketImgDaoImplTest extends Object {

    @Autowired
    private TicketImgDao ticketImgDao;

    @Test
    void insertTicketImg() {
    }

    @Test
    void selectByTicketImg() throws Exception {
        List<TicketImg> ticketImgList = ticketImgDao.selectByTicketImg(1);
        assertEquals(ticketImgList.size(), 1);

    }
}