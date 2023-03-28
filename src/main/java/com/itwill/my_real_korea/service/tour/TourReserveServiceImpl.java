package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dto.tour.TourReserve;
import com.itwill.my_real_korea.mapper.TourReserveMapper;
@Service
public class TourReserveServiceImpl implements TourReserveDao {
	@Autowired
	private TourReserveDao tourReserveDao;
	
	public TourReserveServiceImpl() {
		System.out.println("TourReserveServiceImp 기본생성자 호출");
	}

	@Override
	public int insertTourReserve(TourReserve tourReserve) throws Exception {
		//투어예약 추가
		return tourReserveDao.insertTourReserve(tourReserve);
	}

	@Override
	public int updateTourReserve(TourReserve tourReserve) throws Exception {
		//투어예약 변경
		return tourReserveDao.updateTourReserve(tourReserve);
	}

	@Override
	public int deleteTourReserve(int toRsNo) throws Exception {
		//투어예약 삭제 
		return tourReserveDao.deleteTourReserve(toRsNo);
	}

	@Override
	public TourReserve selectByToRsNo(int toRsNo) throws Exception {
		//투어예약번호로 예약 상세보기
		return tourReserveDao.selectByToRsNo(toRsNo);
	}

	@Override
	public List<TourReserve> selectAllTourReserveByUserId(String userId) throws Exception {
		//유저의 투어예약 리스트 전체 보여주기
		return tourReserveDao.selectAllTourReserveByUserId(userId);
	}

	@Override
	public int deleteAllTourReserveByUserId(String userId) throws Exception {
		//유저의 투어예약 전체 삭제
		return tourReserveDao.deleteAllTourReserveByUserId(userId);
	}

}
