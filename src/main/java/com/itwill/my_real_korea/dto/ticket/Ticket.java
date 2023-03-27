package com.itwill.my_real_korea.dto.ticket;

import java.util.Date;

import com.itwill.my_real_korea.dto.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private int tiNo;
    private String tiTitle;
    private Date tiDate;
    private String tiInfo;
    private String tiNotice;
    private int tiCount;
    private City city; 
}
