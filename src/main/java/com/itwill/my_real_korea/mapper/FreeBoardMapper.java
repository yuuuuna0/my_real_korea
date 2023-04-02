
package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.util.PageMakerDto;


@Mapper
public interface FreeBoardMapper {

 public int insertBoard(FreeBoard freeBoard) ;

 FreeBoard selectByNo(int no) ;

 List<FreeBoard> selectAll(Map<String, Object> pageMap) ;

 int updateBoard(FreeBoard freeBoard) ;

 int deleteBoard(int no) ;

 int increaseReadCount(int no);

 int selectFreeBoardCount() throws Exception;


 int selectSearchCount(String keyword) throws Exception;


 List<FreeBoard> selectSearchFreeBoardList(Map<String, Object> keywordPageMap) throws Exception;
}
