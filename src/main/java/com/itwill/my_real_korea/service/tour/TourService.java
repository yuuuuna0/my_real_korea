package com.itwill.my_real_korea.service.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;

public interface TourService {
	//1. 투어 상품 추가
	int insertTour(Tour tour) throws Exception;
	//2. 투어 상품 변경
	int updateTour(Tour tour) throws Exception;
	//3. 투어 상품 삭제
	int deleteTour(int toNo) throws Exception;
	//4. 투어 상세보기
	Tour findTourWithCityByToNo(int toNo) throws Exception;
	//5. 투어 전체 리스트 보기
	List<Tour> findTourWithTourImgWithCityAll() throws Exception;
	//6. 키워드로 검색 한 투어상품리스트
	List<Tour> findTourListByKeyword(String keyword) throws Exception;
	//7. 지역으로 투어상품 검색
	List<Tour> findTourListByCityNo(int cityNo) throws Exception;
	//8. 여행타입으로 투어상품 검색
	List<Tour> findTourListByToType(int toType) throws Exception;
	
	
}
