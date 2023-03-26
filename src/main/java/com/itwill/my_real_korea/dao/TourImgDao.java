package com.itwill.my_real_korea.dao;

import java.util.List;

import com.itwill.my_real_korea.dto.TourImg;

public interface TourImgDao {
	//1. 투어이미지 추가
	public int insertTourImg(TourImg tourImg);
	//2. 투어이미지 삭제
	public int deleteTourImg(int toImgNo);
	//3. 투어번호 해당 투어이미지 전체출력
	public List<TourImg> selectTourImgList(int to_no);
}
