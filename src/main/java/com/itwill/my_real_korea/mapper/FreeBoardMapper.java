
package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardCommentListPageMakerDto;


@Mapper
public interface FreeBoardMapper {

 public int insertBoard(FreeBoard freeBoard) ;

 FreeBoard selectByNo(int no) ;

 List<FreeBoard> selectAll(Map<String, Object> pageMap) ;

 int updateBoard(FreeBoard freeBoard) ;

 int deleteBoard(int no) ;

 int increaseReadCount(int no);
 /*
  * 공지사항 게시글 총 개수 조회
  */
 int selectFreeBoardCount() throws Exception;

 /*
  * 검색된 게시글 총 개수 조회
  */
 int selectSearchCount(String keyword) throws Exception;

 /*
  * 공지사항 게시판 title 키워드로 검색
  */
 List<FreeBoard> selectSearchFreeBoardList(Map<String, Object> keywordPageMap) throws Exception;
}
