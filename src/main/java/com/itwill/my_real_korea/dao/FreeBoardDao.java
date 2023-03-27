package com.itwill.my_real_korea.Dao;

import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.service.FreeBoard;
import com.itwill.my_real_korea.service.FreeBoardListPageMakerDto;

public interface FreeBoardDao {

/*
 * 자유게시판 게시글 추가
 */
int insertContent(FreeBoard freeBoard) throws Exception;
/*
 * 자유게시판 게시글,댓글 번호(boardno)로 해당 게시글 보기 
 */
 selectByNo(int fBoNo) throws Exception;
/*
 * 자유게시판 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
 */
List<FreeBoard> selectAll(int pageStart, int pageEnd) throws Exception;

FreeBoardListPageMakerDto selectAll(int currentPage) throws Exception;

/*
 * 게시글,댓글 title 출력 설정
 */
String getTitleString(FreeBoard freeBoard) throws Exception;

/*
 *  게시글,댓글 삭제
 */
int deleteContent(int fBoNo) throws Exception;
/*
 *  게시글,댓글 내용 수정
 */
int updateContent(FreeBoard freeBoard) throws Exception;
/*
 * 공지사항 게시글 조회수 1 증가
 */
int increaseContentReadCount(int fBoNo) throws Exception;
/*
 * 공지사항 게시글,댓글 총 개수 조회
 */
int selectContentCount() throws Exception;

/*
 * 검색된 게시글 총 개수 조회
 */
int selectSearchCount(String keyword) throws Exception;

/*
 *  게시판 title 키워드로 검색
 */
List<FreeBoard> selectSearchNoticeList(int pageStart, int pageEnd, String keyword) throws Exception;

FreeBoardListPageMakerDto selectSearchFreeBoardList(int currentPage, String keyword) throws Exception;
}
