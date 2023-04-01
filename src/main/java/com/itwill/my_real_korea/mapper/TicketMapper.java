package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.ticket.Ticket;

@Mapper
public interface TicketMapper {


    /**create**/
	//티켓 추가
    int insertTicket (Ticket ticket);

    /**read**/
    //티켓번호로 찾기
    List<Ticket> selectByTicketNo(int tiNo);
    //티켓 리스트
    List<Ticket> selectAllTicket(Map<String,Object> ticketpageMap);
    //상품 키워드로 검색
    List<Ticket> selectByKeywordTicket(Map<String, Object> ticketKeywordPageMap);
    //가격 순
    List<Ticket> selectByTicketPrice(Map<String,Object> ticketPriceSortMap );
    //상품 상세보기 - 지역
    List<Ticket> selectByTicketNoCityWithImg(int tiNo);

    //상품 지역별 검색
    List<Ticket> selectByTicketCity(int cityNo);

    /**update**/   
    //티켓 수정
    int updateTicket(Ticket ticket);
    
    /**delete**/
    //티켓 삭제
    int deleteTicket(int tiNo);

    //Query TEST
    List<Ticket> testQuery(Map<String, Object> testQueryMap);

}
