package com.itwill.my_real_korea.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.UserImg;

@Mapper
public interface UserImgMapper {
	//유저 이미지 추가
	public int createUserImg(UserImg userImg);
	//유저 이미지 수정
	public int updateUserImg(UserImg userImg);
	//유저 이미지 삭제
	public int removeUserImg(int userImgNo);
	//유저 아이디로 유저 이미지 찾기
	public UserImg findUserImg(String userId);

}
