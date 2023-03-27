
package com.itwill.my_real_korea.dao.freeboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
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
	public int insertContent(FreeBoard freeBoard) throws Exception {
		return freeBoardMapper.insertContent(freeBoard);
	}
	@Override
	public int selectByNo(int fBoNo) throws Exception {
		return freeBoardMapper.selectByNo(fBoNo);
	}
	@Override
	public List<FreeBoard> selectAll(int pageStart, int pageEnd) throws Exception {
		return freeBoardMapper.selectAll(pageStart, pageEnd);
	}
	@Override
	public String getTitleString(FreeBoard freeBoard) throws Exception {
		return freeBoardMapper.getTitleString(freeBoard);
	}
	@Override
	public int deleteContent(int fBoNo) throws Exception {
		return freeBoardMapper.deleteContent(fBoNo);
	}
	@Override
	public int updateContent(FreeBoard freeBoard) throws Exception {
		return freeBoardMapper.updateContent(freeBoard);
	}
	@Override
	public int increaseContentReadCount(int fBoCount) throws Exception {
		return freeBoardMapper.increaseContentReadCount(fBoCount);
	}
	@Override
	public int selectContentCount() throws Exception {
		return freeBoardMapper.selectContentCount();
	}
	@Override
	public int selectSearchCount(String keyword) throws Exception {
		return freeBoardMapper.selectSearchCount(keyword);
	}
	@Override
	public List<FreeBoard> selectSearchNoticeList(int pageStart, int pageEnd, String keyword) throws Exception {
		return freeBoardMapper.selectSearchNoticeList(pageStart, pageEnd, keyword);
	}
	
//	@Override
//	public int insertContent(FreeBoard freeBoard) throws Exception{
//		return freeBoardMapper.insertContent(freeBoard);
//	}
//	@Override
//	public int updateContent(FreeBoard freeBoard) throws Exception{
//		return freeBoardMapper.updateContent(freeBoard);
//	}
//	@Override
//	public int deleteContent(FreeBoard freeBoard) throws Exception{
//		return freeBoardMapper.deleteContent(freeBoard);
//	}
//	@Override
//	public int selectSearchCount(String keyword) throws Exception {
//		return freeBoardMapper.selectSearchCount(keyword);
//	}
//	@Override
//	public FreeBoard selectByNo(int fBoNo) throws Exception {
//		return freeBoardMapper.selectByNo(fBoNo);
//	}

}
