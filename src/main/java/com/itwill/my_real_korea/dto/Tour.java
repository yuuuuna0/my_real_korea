package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
이름        널?       유형             
--------- -------- -------------- 
TO_NO     NOT NULL NUMBER         
TO_NAME   NOT NULL VARCHAR2(1000) 
TO_TYPE   NOT NULL NUMBER         
TO_TIME   NOT NULL NUMBER         
TO_PERSON NOT NULL NUMBER         
TO_MEET   NOT NULL VARCHAR2(100)  
TO_PRICE  NOT NULL NUMBER         
TO_INFO   NOT NULL VARCHAR2(4000) 
TO_NOTICE NOT NULL VARCHAR2(1000) 
TO_COUNT           NUMBER         
CITY_NO            NUMBER     
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
	private int toNo;
	private String toName;
	private int toType;
	private int toTime;
	private int toPerson;
	private String toMeet;
	private int toPrice;
	private String toInfo;
	private String toNotice;
	private int toCount;
	private City city;		//FK
	private TourImg tourImg;	//FK
	private TourReview tourReview;	//FK
	private TourReserve tourReserve;	//FK
	private TourWishlist tourWishlist;	//FK
	
	
}
