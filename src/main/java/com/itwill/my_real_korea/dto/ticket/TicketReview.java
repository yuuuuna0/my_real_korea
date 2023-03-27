package com.itwill.my_real_korea.dto.ticket;

import java.util.Date;

import com.itwill.my_real_korea.dto.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReview {

    private int TiReviewNo;
    private Date TiReviewDate;
    private String TiReviewTitle;
    private String TiReviewContent;
    private Ticket ticket;
    private String userinfo;
    
}
