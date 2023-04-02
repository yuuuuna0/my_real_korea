package com.itwill.my_real_korea.service.user;

import com.itwill.my_real_korea.dto.user.UserAddInfo;

public interface UserAddInfoService {

	int createUserAddInfo(UserAddInfo userAddInfo) throws Exception;
	
	int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception;
	
	int removeUserAddInfo(String userId) throws Exception;
	
	UserAddInfo findUserAddInfo(String userId) throws Exception;



}