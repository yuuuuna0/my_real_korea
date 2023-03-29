package com.itwill.my_real_korea.mapper;

import com.itwill.my_real_korea.dao.ticket.TicketReview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TicketReviewMapper {

    //티켓 리뷰 작성
    int insertTicketReview(TicketReview ticketReview);
    //티켓 리뷰 보기
    List<TicketReview> selectByTicketReview(int TiReviewNo);
    //내 리뷰 보기
    List<TicketReview> selectByTicketReviewUser(String userId);

    //리뷰 수정
    int updateTicketReview(TicketReview ticketReview);

    //리뷰 삭제
    int deleteTicketReview(int TiReviewNo);

}
