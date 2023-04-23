package com.itwill.my_real_korea.service.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.util.PageMakerDto;

public interface TicketReviewService {

    int insertTicketReview(TicketReview ticketReview);
    
    TicketReview selectByTicketReviewOne(int tiReviewNo);
    
   //티켓 리뷰 보기
    List<TicketReview> selectByTicketReviewNo(int tiNo);
    
    //내 리뷰 보기
    List<TicketReview> selectByTicketReviewUser(String userId);

    //리뷰 수정
    int updateTicketReview(TicketReview ticketReview);

    //리뷰 삭제
    int deleteTicketReview(int tiReviewNo);

    //티켓 평점
    int calculateTourScore(int tiNo) throws Exception;


    /*파일*/
    int ticketReviewImg(String tiReviewImg, int tiReviewNo); // 기존 이미지
    //수정 이미지
    int tiReviewImgUpload(String tiReviewImgUpload, int tiReviewNo); // 업로드 이미지
    
    int ticketReviewImgNull (int tiReviewNo);
    
    
    /* 페이징 
     *  //티켓 리뷰 보기
    PageMakerDto<TicketReview> selectByTicketReview(int currentPage , int tiReviewNo) throws Exception;

    //내 리뷰 보기
    PageMakerDto<TicketReview> selectByTicketReviewUser(int currentPage , String userId) throws Exception;
     */
}
