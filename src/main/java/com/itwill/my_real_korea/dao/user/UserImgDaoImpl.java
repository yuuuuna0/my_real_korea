package com.itwill.my_real_korea.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.user.UserImg;
import com.itwill.my_real_korea.mapper.UserImgMapper;
@Repository
public class UserImgDaoImpl implements UserImgDao {
	
	@Autowired(required=true)
	private UserImgMapper userImgMapper;
	
	public UserImgDaoImpl() {
	}
	
	@Override
	public int createUserImg(UserImg userImg) {
		return userImgMapper.createUserImg(userImg);
	}
	
	@Override
	public int updateUserImg(UserImg userImg) {
		return userImgMapper.updateUserImg(userImg);
	}
	
	@Override
	public int removeUserImg(int userImgNo) {
		return userImgMapper.removeUserImg(userImgNo);
	}
	
	@Override
	public UserImg findUserImg(String userId) {
		return userImgMapper.findUserImg(userId);
	}
	
	
	

}
