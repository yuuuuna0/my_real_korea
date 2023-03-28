package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourWishlistDao;
import com.itwill.my_real_korea.dto.tour.TourWishlist;
import com.itwill.my_real_korea.mapper.TourWishlistMapper;
@Service
public class TourWishlistServiceImpl implements TourWishlistService {
	@Autowired
	private TourWishlistDao tourWishlistDao;
	
	public TourWishlistServiceImpl() {
		System.out.println("TourWishlistServiceImp 기본생성자 호출");
	}

	@Override
	public int insertTourWishlist(TourWishlist tourWishlist) throws Exception {
		//투어위시리스트 추가하기
		return tourWishlistDao.insertTourWishlist(tourWishlist);
	}

	@Override
	public int deleteTourWishlist(int toWishNo) throws Exception {
		//투어위시리스트 삭제하기
		return tourWishlistDao.deleteTourWishlist(toWishNo);
	}

	@Override
	public List<TourWishlist> selectAllWishlistByUserId(String userId) throws Exception {
		//유저의 투어위시리스트 전체보기
		return tourWishlistDao.selectAllWishlistByUserId(userId);
	}

	@Override
	public TourWishlist selectWishlistByToWishNo(int toWishNo) throws Exception {
		//투어위시리스트 중 하나 상세보기
		return tourWishlistDao.selectWishlistByToWishNo(toWishNo);
	}

}
