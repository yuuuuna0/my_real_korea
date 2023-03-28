package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dao.tour.TourDao;
import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.tour.Tour;

@Service
public class TourServiceImpl implements TourService{
	@Autowired
	private TourDao tourDao;

	public TourServiceImpl() {
		System.out.println("TourServiceImp 기본생성자 호출");
	}
	
	@Override
	public int insertTour(Tour tour) throws Exception {
		// 투어상품 추가
		return tourDao.insertTour(tour);
	}

	@Override
	public int updateTour(Tour tour) throws Exception {
		// 투어상품 수정
		return tourDao.updateTour(tour);
	}

	@Override
	public List<Tour> selectAll() throws Exception {
		// 투어상품 리스트 전체 출력
		return tourDao.selectAll();
	}

	@Override
	public Tour selectByToNo(int toNo) throws Exception {
		// 투어상품 상품번호로 상세보기
		return tourDao.selectByToNo(toNo);
	}

	@Override
	public List<Tour> selectByKeyword(String keyword) throws Exception {
		// 키워드로 투어상품 검색
		return tourDao.selectByKeyword(keyword);
	}

	@Override
	public List<Tour> selectByCityNo(int cityNo) throws Exception {
		// 지역으로 투어상품 검색 
		return tourDao.selectByCityNo(cityNo);
	}

	@Override
	public List<Tour> selectByToType(int toType) throws Exception {
		// 여행타입으로 투어상품 검색
		return tourDao.selectByToType(toType);
	}

	@Override
	public int deleteTour(int toNo) throws Exception {
		// 투어상품 삭제
		return tourDao.deleteTour(toNo);
	}
}
