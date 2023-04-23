package com.itwill.my_real_korea.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.ticket.TicketReview;

import java.util.List;
import java.util.Map;

@Mapper
public interface TicketReviewMapper {

    //티켓 리뷰 작성
    int insertTicketReview(TicketReview ticketReview);
    
    TicketReview selectByTicketReviewOne(int tiReviewNo);
    
    //티켓 리뷰 보기
    List<TicketReview> selectByTicketReviewNo(int tiNo);

    //내 리뷰 보기
    List<TicketReview> selectByTicketReviewUser(String userId);

    //리뷰 수정
    int updateTicketReview(TicketReview ticketReview);

    //리뷰 삭제
    int deleteTicketReview(int TiReviewNo);
    
    int ticketReviewImg(String tiReviewImg, int tiReviewNo); // 기존 이미지
    int tiReviewImgUpload(String tiReviewImgUpload, int tiReviewNo); // 업로드 이미지
    int ticketReviewImgNull(int tiReviewNo);


 
    
    /*
     페이징
     int selectAllReviewCount();
    //티켓 리뷰 보기
    List<TicketReview> selectByTicketReview(Map<String, Object> ticketReviewList);
    //내 리뷰 보기
    List<TicketReview> selectByTicketReviewUser(Map<String, Object> ticketReviewUserList);
     */

}
