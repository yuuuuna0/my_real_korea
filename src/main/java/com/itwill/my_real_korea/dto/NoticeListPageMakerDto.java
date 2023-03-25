package com.itwill.my_real_korea.dto;
/*
 * 게시글 리스트 페이지에서 
 * 출력에 필요한 테이블 데이터 및 페이징 처리에 필요한 정보
 */

import java.util.List;

import com.itwill.my_real_korea.util.PageMaker;


public class NoticeListPageMakerDto {
	public List<Notice> itemList;
	public PageMaker pageMaker;
}
