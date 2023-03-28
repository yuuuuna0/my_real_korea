package com.itwill.my_real_korea.service.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentService {
	/*
	 * 자유게시판 댓글 추가
	 */
	int insertComment(FreeBoardComment freeBoardComment) throws Exception;
	/*
	 * 자유게시판 게시글,댓글 번호(boardno)로 해당 게시글 보기 
	 */
	int selectByNo(int fCommentNo) throws Exception;
	
	int selectByContentNo(int fBoNo) throws Exception;
	/*
	 * 자유게시판 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 */
	List<FreeBoardComment> selectAll(int pageStart, int pageEnd) throws Exception;
	
	FreeBoardCommentListPageMakerDto selectAll(int currentPage) throws Exception;
	/*
	 * 게시글,댓글 title 출력 설정
	 */
	String getTitleString(FreeBoardComment freeBoardComment) throws Exception;
	
	/*
	 *  게시글,댓글 삭제
	 */
	int deleteComment(int fCommentNo) throws Exception;
	/*
	 *  게시글,댓글 내용 수정
	 */
	int updateComment(FreeBoardComment freeBoardComment) throws Exception;
	/*
	 * 공지사항 게시글 조회수 1 증가
	 */
	int increaseCommentReadCount(int fCommentNo) throws Exception;
	/*
	 * 공지사항 게시글,댓글 총 개수 조회
	 */
	int selectCommentCount() throws Exception;
	
}
