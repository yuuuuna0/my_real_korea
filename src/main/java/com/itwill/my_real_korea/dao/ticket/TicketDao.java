package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.Ticket;

public interface TicketDao {

    // 티켓 생성
    int insertTicket(Ticket ticket) throws Exception;

    // 티켓 번호로 찾기
    Ticket selectByNo(int tiNo) throws Exception;

    // 티켓 리스트
    List<Ticket> selectAll() throws Exception;
    // 티켓 가격 순
    List<Ticket> selectTicketPrice(String sortOrder) throws Exception;
    
    // 티켓 수정
    int updateTicket(Ticket ticket) throws Exception;
    
    // 티켓 삭제
    int deleteTicket(int tiNo) throws Exception;
    
    
}
