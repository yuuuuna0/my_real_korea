package com.itwill.my_real_korea.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketImg {

    private int tiReviewImgNo;
    private String tiReviewImgUrl;
    private TicketReview ticketReview;


}
