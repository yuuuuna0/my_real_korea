package com.itwill.my_real_korea.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.User;
import com.itwill.my_real_korea.mapper.UserMapper;
@Repository(value = "userDaoImplMyBatisMapperInterface")
public class UserDaoImpl implements UserDao {
	
	@Autowired(required = false)
	private UserMapper userMapper;

	public UserDaoImpl() {
	}
	
	//회원 가입
	@Override
	public int create(User user) throws Exception {
		return userMapper.create(user);
	}

	//회원 정보 수정
	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	//회원 탈퇴
	@Override
	public int remove(String userId) throws Exception {
		return userMapper.remove(userId);
	}

	//회원 정보 보기 (마이페이지)
	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	//전체 회원 정보 보기 (관리자 페이지)
	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}
	
	/*
	 * 	0: 회원 존재
	 * 	1: 회원 존재 안함
	 */
	//회원 존재 여부 확인
	@Override
	public boolean isExistUser(String userId) throws Exception {
		boolean isExist = false;
		int existCount = userMapper.isExistUser(userId);
		if(existCount == 1) {
			isExist = true;
		}
		return isExist;
	}
	
	public boolean isMatchPassword(String userId, String password){
		Map<String,Object> map = new HashMap();
		map.put("userId", userId);
		map.put("password", password);
		int matchPassword = userMapper.isMatchPassword(map);
		//패스워드 일치함 => 로그인
		if(matchPassword == 1){
			return true;
		}
		//패스워드 일치 안함
		return false;
	}

}