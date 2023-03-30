package com.itwill.my_real_korea.dao.user;

import java.util.List;

import com.itwill.my_real_korea.dto.user.User;

public interface UserDao {

	int create(User user) throws Exception;

	int update(User user) throws Exception;

	int remove(String userId) throws Exception;

	User findUser(String userId) throws Exception;

	List<User> findUserList() throws Exception;
	
	//회원 존재 여부 확인
	boolean isExistUser(String userId) throws Exception;
	
	boolean isMatchPassword(String userId, String password) throws Exception;
	
	//이메일, 이름으로 아이디 찾기
	String findIdByEmailName(User user) throws Exception;

}