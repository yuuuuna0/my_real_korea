package com.itwill.my_real_korea.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.user.UserAddInfoDao;
import com.itwill.my_real_korea.dto.user.UserAddInfo;

@Service
public class UserAddInfoServiceImpl implements UserAddInfoService {
	
	@Autowired
	private UserAddInfoDao userAddInfoDao;
	
	public UserAddInfoServiceImpl() throws Exception {
	}
	
	@Override
	public int createUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoDao.createUserAddInfo(userAddInfo);
	}
	
	@Override
	public int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoDao.updateUserAddInfo(userAddInfo);
	}
	
	@Override
	public int removeUserAddInfo(String userId) throws Exception {
		return userAddInfoDao.removeUserAddInfo(userId);
	}
	
	@Override
	public UserAddInfo findUserAddInfo(String userId) throws Exception {
		return userAddInfoDao.findUserAddInfo(userId);
	}
	
}















