package com.itwill.my_real_korea.dao.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentDao {

	/*
	 * 자유게시판 답변 추가
	 */
	int insertComment(FreeBoardComment freeBoardComment) throws Exception;
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

