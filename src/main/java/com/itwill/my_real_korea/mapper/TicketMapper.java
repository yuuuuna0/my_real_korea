package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.ticket.Ticket;

@Mapper
public interface TicketMapper {

	/**create**/
	//티켓 추가
    public int insertTicket (Ticket ticket);
    
    /**read**/
    //티켓번호로 찾기
    public Ticket selectByNo(int tiNo);
    //티켓 리스트
    public List<Ticket> selectAll();
    //검색어
    public List<Ticket> keywordTicket(String keyword);
    //가격 순
    public List<Ticket> selectTicketPrice(String sortOrder);
   
    /**update**/   
    //티켓 수정
    public int updateTicket(Ticket ticket);
    
    /**delete**/
    //티켓 삭제
    public int deleteTicket(int tiNo);

	
    


}
