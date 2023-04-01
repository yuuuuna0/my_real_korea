package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.Ticket;

public interface TicketDao {

    // 티켓 생성
    int insertTicket(Ticket ticket) throws Exception;
    // 티켓 리스트
    List<Ticket> selectAllTicket(int pageStart, int pageEnd) throws Exception;
    // 상품 가격 순으로 검색
    List<Ticket> selectByTicketPrice(int pageStart, int pageEnd, String sortOrder) throws Exception;

    // 상품 지역별 검색
    List<Ticket> selectByTicketCity(int pageStart, int pageEnd, int cityNo) throws Exception;

    // 상품 키워드로 검색
    List<Ticket> selectByKeywordTicket (int pageStart, int pageEnd, String keyword) throws Exception;

    //상품 상세보기 - 지역
    List<Ticket> selectByTicketNoCityWithImg(int tiNo) throws Exception;

    // 상품 번호로 수정
    int updateTicket(Ticket ticket) throws Exception;
    
    // 티켓 삭제
    int deleteTicket(int tiNo) throws Exception;
    
    //Test
    List<Ticket> selectTest(String keyword,
                           int pageStart, int pageEnd,
                           int cityNo, String sortOrder) throws Exception;
}
