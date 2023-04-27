package com.itwill.my_real_korea.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.Location;

@Mapper
public interface LocationMapper {
	//1. 투어번호로 위치 찾기
	Location findByToNo(int toNo) throws Exception;
	//2. 티켓번호로 위치 찾기
	Location findByTiNo(int tiNo) throws Exception;
}
