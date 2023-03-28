
package com.itwill.my_real_korea.dao.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardListPageMakerDto;

public interface FreeBoardDao {
    int insertBoard(FreeBoard freeBoard) throws Exception;

    FreeBoard selectByNo(int no) throws Exception;

    List<FreeBoard> selectAll(int pageStart, int pageEnd) throws Exception;

    int updateBoard(FreeBoard freeBoard) throws Exception;

    int deleteBoard(int no) throws Exception;

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
}
