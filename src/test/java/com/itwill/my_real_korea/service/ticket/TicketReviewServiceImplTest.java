package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dto.ticket.TicketReview;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class TicketReviewServiceImplTest {
    @Autowired
    TicketReviewService ticketReviewService;

    @Disabled
    @Test //date format
    void insertTicketReview() {
        System.out.print(ticketReviewService.insertTicketReview(
                new TicketReview(0,new Date(), "후기작성",
                        "후기를 써야하나?","review.jpg",3,"user3")));

    }
/*
    @Disabled
    @Test
    void selectByTicketReview() throws Exception{
        System.out.println(ticketReviewService.selectByTicketReview(1,3));
    }

    @Disabled
    @Test
    void testSelectByTicketReview() throws Exception{
        System.out.println(ticketReviewService.selectByTicketReviewUser(1,"user3"));

    }
*/
    @Disabled
    @Test
    void updateTicketReview() {
        assertEquals(ticketReviewService.updateTicketReview(new TicketReview(1,null,"후기수정할게요","사진넣었어요","티켓예약1번후기사진.jpg",0,null)),1);

    }

    @Disabled
    @Test
    void deleteTicketReview() {
        assertEquals(ticketReviewService.deleteTicketReview(4),1);
    }

}