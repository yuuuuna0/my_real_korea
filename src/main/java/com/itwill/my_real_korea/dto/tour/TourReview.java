package com.itwill.my_real_korea.dto.tour;

import java.util.Date;

import com.itwill.my_real_korea.dto.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름                널?       유형             
----------------- -------- -------------- 
TO_REVIEW_NO      NOT NULL NUMBER         
TO_REVIEW_DATE             DATE           
TO_REVIEW_TITLE   NOT NULL VARCHAR2(1000) 
TO_REVIEW_CONTENT NOT NULL VARCHAR2(2000) 
TO_REVIEW_IMG              VARCHAR2(500)  
TO_REVIEW_STAR    NOT NULL NUMBER         
TO_NO                      NUMBER         
USER_ID                    VARCHAR2(50)   

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourReview {
	private int toReviewNo;
	private Date toReviewDate;
	private String toReviewTitle;
	private String toReviewContent;
	private String toReviewImg;
	private int toReviewStar;
	private int toNo;	//FK
	private User users;	//FK
	private String toReviewUpload;
	private Tour tour;
	
	public TourReview(int toReviewNo, Date toReviewDate, String toReviewTitle, String toReviewContent,
			String toReviewImg, int toReviewStar, int toNo) {
		this.toReviewNo = toReviewNo;
		this.toReviewDate = toReviewDate;
		this.toReviewTitle = toReviewTitle;
		this.toReviewContent = toReviewContent;
		this.toReviewImg = toReviewImg;
		this.toReviewStar = toReviewStar;
		this.toNo = toNo;
		this.users = new User();
		this.tour=new Tour();
	}
	
}
