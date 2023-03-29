package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.Ticket;

public interface TicketDao {

    // 티켓 생성
    int insertTicket(Ticket ticket) throws Exception;
    // 티켓 리스트
    List<Ticket> selectAll() throws Exception;
    // 상품 가격 순으로 검색
    List<Ticket> selectByTicketPrice(String sortOrder) throws Exception;
    // 상품 지역별 검색
    List<Ticket> selectByTicketCity(int cityNo) throws Exception;

    // 상품 키워드로 검색
    List<Ticket> selectByKeywordTicket (String keyword) throws Exception;

    //상품 상세보기 - 지역
    List<Ticket> selectByTicketNoCity(int cityNo) throws Exception;

    // 상품 번호로 수정
    int updateTicket(Ticket ticket) throws Exception;
    
    // 티켓 삭제
    int deleteTicket(int tiNo) throws Exception;
    
    
}
