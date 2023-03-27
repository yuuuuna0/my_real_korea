package com.itwill.my_real_korea.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.FreeBoard;
import com.itwill.my_real_korea.dto.Notice;
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
	@Override
	public int updateContent(FreeBoard freeBoard) throws Exception{
		return freeBoardMapper.updateContent(freeBoard);
	}
	@Override
	public int deleteContent(FreeBoard freeBoard) throws Exception{
		return freeBoardMapper.deleteContent(freeBoard);
	}
	@Override
	public int selectByNo(int fBoNo) throws Exception{
		return freeBoardMapper.selectByNo(fBoNo);
	}
	@Override
	public int increaseReadCount(int fBoNo) throwsException{
		return freeBoardMapper.increaseReadCount(fBoNo);
	}
	@Override
	public int selectCount() throws Exception {
		return freeBoardMapper.selectCount();
	}

	@Override
	public int selectSearchCount(String keyword) throws Exception {
		return freeBoardMapper.selectSearchCount(keyword);
	}

	@Override
	public List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("keyword", keyword);
		
		return freeBoardMapper.selectSearchFreeBoardList(pageMap);
	}
}
