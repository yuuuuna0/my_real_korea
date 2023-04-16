package com.itwill.my_real_korea.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketImg {

    private int tiImgNo; // 
    private String tiImgUrl; // 실제파일이름
    private int tiNo; //티켓 no.


}
