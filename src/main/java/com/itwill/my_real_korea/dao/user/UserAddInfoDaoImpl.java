package com.itwill.my_real_korea.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.user.UserAddInfo;
import com.itwill.my_real_korea.mapper.UserAddInfoMapper;
@Repository
public class UserAddInfoDaoImpl implements UserAddInfoDao {
	
	@Autowired
	private UserAddInfoMapper userAddInfoMapper;

	public UserAddInfoDaoImpl() {
	}
	
	@Override
	public int createUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoMapper.createUserAddInfo(userAddInfo);
	}

	@Override
	public int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoMapper.updateUserAddInfo(userAddInfo);
	}

	@Override
	public int removeUserAddInfo(String userId) throws Exception {
		return userAddInfoMapper.removeUserAddInfo(userId);
	}

	@Override
	public UserAddInfo findUserAddInfo(String userId) throws Exception {
		return userAddInfoMapper.findUserAddInfo(userId);
	}



}