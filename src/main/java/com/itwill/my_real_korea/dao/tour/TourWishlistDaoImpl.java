package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tour.TourWishlist;
import com.itwill.my_real_korea.mapper.tour.TourWishlistMapper;
@Repository
public class TourWishlistDaoImpl implements TourWishlistDao {
	@Autowired
	private TourWishlistMapper tourWishlistMapper;
	
	public TourWishlistDaoImpl() {
		System.out.println("TourWishlistDaoImp 기본생성자 호출");
	}

	@Override
	public int insertTourWishlist(TourWishlist tourWishlist) throws Exception {
		//투어위시리스트 추가하기
		return tourWishlistMapper.insertTourWishlist(tourWishlist);
	}

	@Override
	public int deleteTourWishlist(int toWishNo) throws Exception {
		//투어위시리스트 삭제하기
		return tourWishlistMapper.deleteTourWishlist(toWishNo);
	}

	@Override
	public List<TourWishlist> selectAllWishlistByUserId(String userId) throws Exception {
		//유저의 투어위시리스트 전체보기
		return tourWishlistMapper.selectAllWishlistByUserId(userId);
	}

	@Override
	public TourWishlist selectWishlistByToWishNo(int toWishNo) throws Exception {
		//투어위시리스트 중 하나 상세보기
		return tourWishlistMapper.selectWishlistByToWishNo(toWishNo);
	}

}
