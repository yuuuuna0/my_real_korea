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

    private int tiReviewNo;
    private Date tiReviewDate;
    private String tiReviewTitle;
    private String tiReviewContent;
    private String tiReviewImg;
    private String tiReviewImgUpload;   //수정된 이미지
    private int tiReviewStar;
	private int tiNo;
    private User user;
    private Ticket ticket;
    public TicketReview(int tiReviewNo, Date tiReviewDate, String tiReviewTitle, String tiReviewContent,
    		String tiReviewImg, String tiReviewImgUpload, int tiReviewStar, int tiNo, User user) {
    	super();
    	this.tiReviewNo = tiReviewNo;
    	this.tiReviewDate = tiReviewDate;
    	this.tiReviewTitle = tiReviewTitle;
    	this.tiReviewContent = tiReviewContent;
    	this.tiReviewImg = tiReviewImg;
    	this.tiReviewImgUpload = tiReviewImgUpload;
    	this.tiReviewStar = tiReviewStar;
    	this.tiNo = tiNo;
    	this.user = user;
    	this.ticket=new Ticket();
    }

}
