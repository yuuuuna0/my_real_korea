package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름         널?       유형           
---------- -------- ------------ 
TO_WISH_NO NOT NULL NUMBER       
TO_NO               NUMBER       
USER_ID             VARCHAR2(50) 
WISH_NO             NUMBER  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourWishlist {
	private int toWishNo;
	private Tour tour;
	private UserInfo userinfo;
	private Wishlist wishlist;
}
