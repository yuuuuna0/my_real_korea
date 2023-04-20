package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.tour.TourReview;

@Mapper
public interface TourReviewMapper {
	//1. 투어상품 후기 추가
	public int insertTourReview(TourReview tourRiview) throws Exception;
	//2. 투어상품번호로 후기 전체 보기
	//public List<TourReview> selectByToNo(int toNo) throws Exception;
	public List<TourReview> selectByToNo(int toNo) throws Exception;
	//3. 투어후기 수정
	public int updateTourReview(TourReview tourReview) throws Exception;
	//4. 투어후기번호로 후기 삭제
	public int deleteTourReview(int toReviewNo) throws Exception;
	//5. 사용자가 작성한 후기 전체 보기
	public List<TourReview> selectByUserId(String userId) throws Exception;
	//6. 투어상품번호로 찾은 투어 후기 갯수
	public int findCountByToNo(int toNo) throws Exception;
	//7. 사용자가 작성한 후기 갯수 
	public int findCountByUserId(String userId) throws Exception;
	//8. 사진 업로드 할 경우 업로드파일로 업데이트
	public int updateToReviewUpload(Map<String,Object> map) throws Exception;
	//9. 사진 업로드 안 할 경우 의 업데이트
	public int updateToReviewImg(Map<String,Object> map) throws Exception;
	
}
