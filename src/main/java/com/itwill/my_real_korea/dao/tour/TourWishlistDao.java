package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.tour.TourWishlist;

public interface TourWishlistDao {
	//1. 투어위시리스트 추가하기
	int insertTourWishlist(TourWishlist tourWishlist) throws Exception;
	//2. 투어위시리스트 삭제하기
	int deleteTourWishlist(int toWishNo) throws Exception;
	//3. 유저의 투어위시리스트 전체보기
	List<TourWishlist> selectAllWishlistByUserId(String userId) throws Exception;
	//4. 투어위시리스트 중 하나 상세보기
	TourWishlist selectWishlistByToWishNo(int toWishNo) throws Exception;
}
