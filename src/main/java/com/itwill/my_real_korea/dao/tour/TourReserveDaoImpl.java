package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tour.TourReserve;
import com.itwill.my_real_korea.mapper.TourReserveMapper;
@Repository
public class TourReserveDaoImpl implements TourReserveDao {
	@Autowired
	private TourReserveMapper tourReserveMapper;
	
	public TourReserveDaoImpl() {
		System.out.println("TourReserveDaoImp 기본생성자 호출");
	}

	@Override
	public int insertTourReserve(TourReserve tourReserve) throws Exception {
		//투어예약 추가
		return tourReserveMapper.insertTourReserve(tourReserve);
	}

	@Override
	public int updateTourReserve(TourReserve tourReserve) throws Exception {
		//투어예약 변경
		return tourReserveMapper.updateTourReserve(tourReserve);
	}

	@Override
	public int deleteTourReserve(int toRsNo) throws Exception {
		//투어예약 삭제 
		return tourReserveMapper.deleteTourReserve(toRsNo);
	}

	@Override
	public TourReserve selectByToRsNo(int toRsNo) throws Exception {
		//투어예약번호로 예약 상세보기
		return tourReserveMapper.selectByToRsNo(toRsNo);
	}

	@Override
	public List<TourReserve> selectAllTourReserveByUserId(String userId) throws Exception {
		//유저의 투어예약 리스트 전체 보여주기
		return tourReserveMapper.selectAllTourReserveByUserId(userId);
	}

	@Override
	public int deleteAllTourReserveByUserId(String userId) throws Exception {
		//유저의 투어예약 전체 삭제
		return tourReserveMapper.deleteAllTourReserveByUserId(userId);
	}

}
