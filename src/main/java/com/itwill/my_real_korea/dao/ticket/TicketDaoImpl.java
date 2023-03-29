package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.mapper.TicketMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao{
	
	private TicketMapper ticketMapper;
	
	@Autowired
	public TicketDaoImpl(TicketMapper ticketMapper) {
		this.ticketMapper = ticketMapper;
	}

	//티켓생성
	@Override
	public int insertTicket(Ticket ticket) throws Exception {
		return ticketMapper.insertTicket(ticket);
	}

	//상품 상세보기 - 지역 + 사진
	public List<Ticket> selectByTicketNoCity(int tiNo) throws Exception{
		return ticketMapper.selectByTicketNoCity(tiNo);
	}

	// 전체 리스트
	@Override
	public List<Ticket> selectAll() throws Exception {
		return ticketMapper.selectAll();
	}
	// 상품 키워드로 검색
	public List<Ticket> selectByKeywordTicket(String keyword) throws Exception{
		return ticketMapper.selectByKeywordTicket(keyword);
	}

	// 상품 가격 순으로 검색
	@Override 
	public List<Ticket> selectByTicketPrice(String sortOrder) throws Exception {
		// 가격 낮은 순 : asc 가격 높은 순 : desc
		return ticketMapper.selectByTicketPrice(sortOrder);
	}

	// 상품 지역별 검색
	@Override
	public List<Ticket> selectByTicketCity(int cityNo) throws Exception {
		return ticketMapper.selectByTicketCity(cityNo);
	}

	//티켓 수정
	@Override
	public int updateTicket(Ticket ticket) throws Exception {
		return ticketMapper.updateTicket(ticket);
	}
	//티켓 삭제
	@Override
	public int deleteTicket(int tiNo) throws Exception {
		return ticketMapper.deleteTicket(tiNo);
	}

	
	

}
