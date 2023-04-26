package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.RsPInfo;
@Mapper
public interface RsPInfoMapper {
	//1. 예약자 정보 입력
		int insertRsPerson(RsPInfo rsPInfo);
		//2. 상품예약자 정보 전체 보기
		RsPInfo selectRsPersonByPNo(int pNo);

}
