package com.itwill.my_real_korea.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.UserAddInfo;

@Mapper
public interface UserAddInfoMapper {

	public int createUserAddInfo(UserAddInfo userAddInfo);
	
	public int updateUserAddInfo(UserAddInfo userAddInfo);
	
	public int removeUserAddInfo(String userId);
	
	public UserAddInfo findUserAddInfo(String userId);
	
	
}
