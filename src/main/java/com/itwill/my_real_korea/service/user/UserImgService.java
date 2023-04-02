package com.itwill.my_real_korea.service.user;

import com.itwill.my_real_korea.dto.user.UserImg;

public interface UserImgService {
	
	int createUserImg(UserImg userImg) throws Exception;
	
	int updateUserImg(UserImg userImg) throws Exception;
	
	int removeUserImg(int userImgNo) throws Exception;
	
	UserImg findUserImg(String userId) throws Exception;

}
