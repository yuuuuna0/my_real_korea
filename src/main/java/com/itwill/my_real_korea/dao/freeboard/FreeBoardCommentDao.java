package com.itwill.my_real_korea.dao.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;

import java.util.List;

public interface FreeBoardCommentDao {


	int insertComment(FreeBoardComment freeBoardComment) throws Exception;

	List<FreeBoardComment> selectByfBoNo(int fBoNo);
	FreeBoardComment selectByfCoNo(int fCoNo);
	List<FreeBoardComment> selectAll() throws Exception;


	int deleteComment(int fCommentNo) throws Exception;

	int updateComment(FreeBoardComment freeBoardComment) throws Exception;

	int selectCommentCount(int fBoNo) throws Exception;


	

	
}

