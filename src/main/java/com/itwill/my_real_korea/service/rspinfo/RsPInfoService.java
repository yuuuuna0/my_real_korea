package com.itwill.my_real_korea.service.rspinfo;

import java.util.List;

import com.itwill.my_real_korea.dto.RsPInfo;

public interface RsPInfoService {
	//1. 예약자 정보 입력
	int insertRsPerson(RsPInfo rsPInfo);
	//2. 상품예약자 정보 전체 보기
	RsPInfo selectRsPersonByPNo(int pNo);

}
