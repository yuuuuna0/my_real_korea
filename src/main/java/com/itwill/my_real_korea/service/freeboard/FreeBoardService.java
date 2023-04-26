package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.util.PageMakerDto;

import java.util.List;

public interface FreeBoardService {
    int insertBoard(FreeBoard freeBoard) throws Exception;

    FreeBoard selectByNo(int fBoNo) throws Exception;

    List<FreeBoard> selectByUserId(String userId) throws Exception;

    int updateFreeBoard(FreeBoard freeBoard) throws Exception;


    int deleteFreeBoard(int no) throws Exception;

    int increaseReadCount(int no) throws Exception;
    //게시글 갯수 조회
    int selectFreeBoardCount() throws Exception;

    // 검색된 게시글 총 개수 조회
    int selectSearchCount(String keyword) throws Exception;
    // 검색된 게시글 총 개수 조회
    int selectCityNoCount(int cityNo) throws Exception;


    //자유게시판 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
    PageMakerDto<FreeBoard> selectAll(int currentPage) throws Exception;

    //최신순 정렬
    PageMakerDto<FreeBoard> selectAllOrderByFBoNoDesc(int currentPage) throws Exception;

    PageMakerDto<FreeBoard> selectAllOrderByFBoNoAsc(int currentPage) throws Exception;

    //조회수 내림차순 정렬
    PageMakerDto<FreeBoard> selectAllOrderByReadCountDesc(int currentPage) throws Exception;

    //title 키워드로 검색
    PageMakerDto<FreeBoard> selectSearchFreeBoardList(int currentPage, String keyword) throws Exception;
    //title 키워드로 검색
    PageMakerDto<FreeBoard> selectFreeBoardCityList(int currentPage, int cityNo) throws Exception;
    //자유게시판 타이틀 14글자 제한
    String getTitleString(FreeBoard freeBoard) throws Exception;


}

