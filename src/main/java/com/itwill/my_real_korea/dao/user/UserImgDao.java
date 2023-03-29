package com.itwill.my_real_korea.dao.user;

import com.itwill.my_real_korea.dto.user.UserImg;

public interface UserImgDao {
	
	int createUserImg(UserImg userImg) throws Exception;
	
	int updateUserImg(UserImg userImg) throws Exception;
	
	int removeUserImg(int userImgNo) throws Exception;
	
	UserImg findUserImg(String userId) throws Exception;

}