package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.TourWishlist;

@Mapper
public interface TourWishlistMapper {
	//1. 투어위시리스트 추가하기
	public int insertTourWishlist(TourWishlist tourWishlist) throws Exception;
	//2. 투어위시리스트 삭제하기
	public int deleteTourWishlist(int toWishNo) throws Exception;
	//3. 유저의 투어위시리스트 전체보기
	public List<TourWishlist> selectAllWishlistByUserId(String userId) throws Exception;
	//4. 투어위시리스트 중 하나 상세보기
	public TourWishlist selectWishlistByToWishNo(int toWishNo) throws Exception;
}