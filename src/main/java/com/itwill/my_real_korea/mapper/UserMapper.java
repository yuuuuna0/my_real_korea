package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.User;

@Mapper
public interface UserMapper {
	
	public int create(User user);
	
	public int update(User user);

	public int remove(String userId);
	
	public User findUser(String userId);
	
	public List<User> findUserList();
	
	public int isExistUser(String userId);
	
	public int isMatchPassword(Map<String,Object> map);
	
	//이메일, 이름으로 아이디 찾기
	public String findIdByEmailName(User user);

	
}