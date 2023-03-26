package com.itwill.my_real_korea.dao;

import java.util.List;

import com.itwill.my_real_korea.dto.TourReview;

public interface TourReviewDao {
	//1. 투어상품 후기 추가
	int insertTourReview(TourReview tourRiview) throws Exception;
	//2. 투어상품번호로 후기 전체 보기
	List<TourReview> selectByToNo(int toNo) throws Exception;
	//3. 투어후기 후기 수정
	int updateTourReview(TourReview tourReview) throws Exception;
	//4. 투어후기번호로 후기 삭제
	int deleteTourReview(int toReviewNo) throws Exception;
	//5. 사용자가 작성한 후기 전체 보기
	List<TourReview> selectByUserId(String userId) throws Exception;
}
