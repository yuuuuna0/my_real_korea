package com.itwill.my_real_korea.dto.wishlist;

import java.util.ArrayList;
import java.util.List;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;

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
@NoArgsConstructor
@ToString
public class Wishlist {

	private int wishNo;
	/* FK */
	private String userId;
	/* FK */
	private int tiNo;
	/* FK */
	private int toNo;
	
	/* ticket 상품 데이터 가져오기 */
	private List<Ticket> ticketList;
	/* tour 상품 데이터 가져오기 */
	private List<Tour> tourList;
	
	public Wishlist(int wishNo, String userId, int tiNo, int toNo) {
		super();
		this.wishNo = wishNo;
		this.userId = userId;
		this.tiNo = tiNo;
		this.toNo = toNo;
		this.ticketList = new ArrayList<>();
		this.tourList = new ArrayList<>();
	}
	
	
	
	
	
}
