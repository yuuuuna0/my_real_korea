package com.itwill.my_real_korea.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.FreeBoard;
import com.itwill.my_real_korea.mapper.FreeBoardMapper;

@Repository
public class FreeBoardDaoImpl implements FreeBoardDao{

	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	public FreeBoardDaoImpl() {
		System.out.println("FreeBoardImpl 기본생성자 호출");
	}
	public FreeBoardMapper getFreeBoardMapper() {
		return freeBoardMapper;
	}
	public void setFreeBoardMapper(FreeBoardMapper freeBoardMapper) {
		System.out.println(">>> freeBoardDaoImpl():setFreeBoardMapper()호출 ");
		this.freeBoardMapper = freeBoardMapper;
	}
	
	@Override
	public int insertContent(FreeBoard freeBoard) throws Exception{
		return freeBoardMapper.insertContent(freeBoard);
	}
}
