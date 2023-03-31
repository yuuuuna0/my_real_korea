package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.tour.Tour;

@Mapper
public interface TourMapper {
	//1. 투어상품 추가
	public int insertTour(Tour tour) throws Exception;
	//2. 투어상품 수정
	public int updateTour(Tour tour) throws Exception;
	//3. 투어상품 리스트 전체 출력
	public List<Tour> findTourWithTourImgWithCityAll() throws Exception;
	//4. 투어상품 상품번호로 상세보기
	public Tour findTourWithCityByToNo(int toNo) throws Exception;
	//5. 키워드로 투어상품 검색
	public List<Tour> findTourListByKeyword(String keyword) throws Exception;
	//6. 지역으로 투어상품 검색
	public List<Tour> findTourListByCityNo(int cityNo) throws Exception;
	//7. 여행타입으로 투어상품 검색
	public List<Tour> findTourListByToType(int toType) throws Exception;
	//8. 투어상품 삭제
	public int deleteTour(int toNo) throws Exception; 
}
