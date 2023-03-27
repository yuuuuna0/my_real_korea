package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.dto.FreeBoardComment;
import com.itwill.my_real_korea.service.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentDao {

package com.itwill.my_real_korea.dao;

import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.dto.FreeBoardComment;
import com.itwill.my_real_korea.dto.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentDao {

	/*
	 * 자유게시판 게시글 추가
	 */
	int insertContent(FreeBoardComment freeBoardComment) throws Exception;
	/*
	 * 답변 번호(boardno)로 해당 답변 보기 
	 */
	FreeBoardComment selectByNo(int fCommentNo) throws Exception;
  /*
	 * 게시물 번호(boardno)로 해당 답변 보기 
	 */
	FreeBoardComment selectByContentNo(int fBoNo) throws Exception;
	/*
	 * 답변 리스트 보기
	 */
	List<FreeBoardComment> selectAll(int pageStart, int pageEnd) throws Exception;
	/*
	 *  답변 삭제
	 */
	int deleteContent(int fCommentNo) throws Exception;
	/*
	 *  답변 내용 수정
	 */
	int updateComment(FreeBoardComment freeBoardComment) throws Exception;
	/*
	 *  답변 조회수 1 증가
	 */
	int increaseCommentReadCount(int fCommentNo) throws Exception;
	/*
	 * 답변 총 개수 조회
	 */
	int selectConmmentCount() throws Exception;

	

	
}

