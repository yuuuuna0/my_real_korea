
package com.itwill.my_real_korea.service.tour;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dao.tour.TourDao;
import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
@Service
public class TourServiceImpl implements TourService {
	@Autowired
	private TourDao tourDao;
//	@Autowired
//	private TourImgDao tourImgDao;
	@Override
	public int insertTour(Tour tour/*,List<TourImg> tourImgList*/) throws Exception {
		//투어상품 추가

//		for (TourImg tourImg : tourImgList) {
//			tourImg.setToNo(tour.getToNo());
//			tourImgDao.insertTourImg(tourImg);
//		}
		return tourDao.insertTour(tour);
	}

	@Override
	public int updateTour(Tour tour) throws Exception {
		//투어상품 변경
		return tourDao.updateTour(tour);
	}

	@Override
	public int deleteTour(int toNo) throws Exception {
		//투어상품 삭제
		return tourDao.deleteTour(toNo);
	}

	@Override
	public Tour findTourWithCityByToNo(int toNo) throws Exception {
		//투어 상세보기
		Tour findTour=tourDao.findTourWithCityByToNo(toNo);
		return findTour;
	}

	@Override
	public List<Tour> findTourWithTourImgWithCityAll() throws Exception {
		//투어 전체 리스트 보기
		return tourDao.findTourWithTourImgWithCityAll();
	}

	@Override
	public List<Tour> findTourListByKeyword(String keyword) throws Exception {
		//키워드로 검색 한 투어상품리스트
		return tourDao.findTourListByKeyword(keyword);
	}

	@Override
	public List<Tour> findTourListByCityNo(int cityNo) throws Exception {
		//지역으로 투어상품 검색
		return tourDao.findTourListByCityNo(cityNo);
	}

	@Override
	public List<Tour> findTourListByToType(int toType) throws Exception {
		//여행타입으로 투어상품 검색
		return tourDao.findTourListByToType(toType);
	}
	
	


}
