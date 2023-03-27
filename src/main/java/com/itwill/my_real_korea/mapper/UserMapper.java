package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.User;

@Mapper
public interface UserMapper {
	
	public int create(User user);
	
	public int update(User user);

	public int remove(String userId);
	
	public User findUser(String userId);
	
	public List<User> findUserList();
	
	public int isExistUser(String userId);
	
	public int isMatchPassword(String password);

	
}