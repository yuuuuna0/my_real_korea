package com.itwill.my_real_korea.service.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardListPageMakerDto;
import com.itwill.my_real_korea.dto.notice.Notice;

public interface FreeBoardService {
	int insertBoard(FreeBoard freeBoard) throws Exception;


	/*
	 * Read
	 */
	FreeBoard selectByNo(int no) throws Exception;

	List<FreeBoard> selectAll(int pageStart, int pageEnd) throws Exception;

	/*
	 * Update
	 */
	int updateFreeBoard(FreeBoard freeBoard) throws Exception;

	/*
	 * Delete
	 */
	int deleteFreeBoard(int no) throws Exception;

	int increaseReadCount(int no) throws Exception;

	int selectFreeBoardCount() throws Exception;

	/*
	 * 검색된 게시글 총 개수 조회
	 */
	int selectSearchCount(String keyword) throws Exception;

	/*
	 * 공지사항 게시판 title 키워드로 검색
	 */
	List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception;

	FreeBoardListPageMakerDto selectAll(int currentPage) throws Exception;
	String getTitleString(FreeBoard freeBoard) throws Exception;
	FreeBoardListPageMakerDto selectSearchFreeBoardList(int currentPage, String keyword) throws Exception;

}

