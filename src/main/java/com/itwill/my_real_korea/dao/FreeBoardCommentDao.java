package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.dto.FreeBoardComment;
import com.itwill.my_real_korea.service.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentDao {

/*
 *  자유게시판 게시글 추가
 */
//int insertComment(FreeBoard freeBoard) throws Exception;
/*
 *  자유게시판 게시글,댓글 번호(boardno)로 해당 게시글 보기 
 */
//FreeBoardComment selectByNo(int fCommentNo) throws Exception;
/*
 * v자유게시판 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
 */

//List<FreeBoardCommentMapper> selectAll(int pageStart, int pageEnd) throws Exception;
//
//FreeBoardCommentListPageMakerDto selectAll(int currentPage) throws Exception;
/*
 * v게시글,댓글 title 출력 설정
 */
String getCommentString(FreeBoardCommentMapper freeBoardComment) throws Exception;

/*
 *  게시글,댓글 삭제
 */
//int deleteContent(int fCommentNo) throws Exception;
/*
 *  게시글,댓글 내용 수정
int updateContent(FreeBoard freeBoard) throws Exception;
int updateConmment(FreeBoardCommentMapper freeBoardComment) throws Exception;
/*
 *  게시글 조회수 1 증가
 */
//int increaseCommentReadCount(int fCommentNo) throws Exception;
/*
 *  게시글,댓글 총 개수 조회
 */
//int selectCommentCount() throws Exception;

}

