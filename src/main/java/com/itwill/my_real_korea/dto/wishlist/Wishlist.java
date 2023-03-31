package com.itwill.my_real_korea.dto.wishlist;

import java.util.ArrayList;
import java.util.List;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
이름      널?       유형           
------- -------- ------------ 
WISH_NO NOT NULL NUMBER       
USER_ID          VARCHAR2(50) 
TI_NO            NUMBER       
TO_NO            NUMBER   
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wishlist {

	private int wishNo;
	/* FK */
	private String userId;
	/* FK : ticket 상품 데이터 가져오기 */
	private Ticket ticket;
	/* FK : tour 상품 데이터 가져오기 */
	private Tour tour;
	
	
}
