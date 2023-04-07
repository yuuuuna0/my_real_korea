package com.itwill.my_real_korea.mapper;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreeBoardCommentMapper {

    int insertComment(FreeBoardComment freeBoardComment) throws Exception;

   List <FreeBoardComment> selectByfBoNo(int fBoNo);

    FreeBoardComment selectByfCoNo(int fCoNo);

    List<FreeBoardComment> selectAll() throws Exception;


    int deleteComment(int fCommentNo) throws Exception;

    int updateComment(FreeBoardComment freeBoardComment) throws Exception;

    int selectCommentCount(int fCommentNo) throws Exception;

}

