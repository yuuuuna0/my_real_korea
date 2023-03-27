package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.mapper.TicketMapper;

public class TicketDaoImpl implements TicketDao{
	
	private final TicketMapper ticketMapper;
	
	@Autowired
	public TicketDaoImpl(TicketMapper tikcetMapper) {
			
		this.ticketMapper = tikcetMapper;
	
	}

	@Override
	public int insertTicket(Ticket ticket) throws Exception {
		return ticketMapper.insertTicket(ticket);
	}

	@Override
	public Ticket selectByNo(int tiNo) throws Exception {
		return ticketMapper.selectByNo(tiNo);
	}
	
	// 전체 리스트
	@Override
	public List<Ticket> selectAll() throws Exception {
		return ticketMapper.selectAll();
	}

	// 검색으로 정렬
	
	public List<Ticket> keywordTicket(String keyword) throws Exception{
		
		return ticketMapper.keywordTicket(keyword);
	}
	
	
	// 가격순으로 정렬
	@Override 
	public List<Ticket> selectTicketPrice(String sortOrder) throws Exception {
		// view에서 처리 - 가격 낮은 순 : asc 가격 높은 순 : desc
		return ticketMapper.selectTicketPrice(sortOrder);
	}
	
	@Override
	public int updateTicket(Ticket ticket) throws Exception {
		return ticketMapper.updateTicket(ticket);
	}

	@Override
	public int deleteTicket(int tiNo) throws Exception {
		return ticketMapper.deleteTicket(tiNo);
	}

	
	

}
