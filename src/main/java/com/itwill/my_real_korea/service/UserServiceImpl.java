package com.itwill.my_real_korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.UserDao;
import com.itwill.my_real_korea.dto.User;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public UserServiceImpl() throws Exception {
		
	}
	//회원 가입
	@Override
	public int create(User user)throws ExistedUserException, Exception{
		//아이디 중복 체크
		if(userDao.isExistUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId() + " 는 이미 존재하는아이디입니다.");
		}
		//회원가입
		return userDao.create(user);
	}
	
	//로그인
	/*
	 *	0: 아이디 존재 안함
	 *	1: 패스워드 일치 안함
	 *	2: 로그인 성공
	 */
	@Override
	public int login(String userId, String password) throws Exception, UserNotFoundException, PasswordMismatchException {
		User user = userDao.findUser(userId);
		if(user == null) {
			throw new UserNotFoundException(userId + " 는 존재하지않는 아이디입니다.");
		}
		if(!user.isMatchPassword(password)){
			throw new PasswordMismatchException("패스워드가 일치하지않습니다.");
		}
		return 2;
	}

	//회원 정보 수정
	@Override
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	
	//회원 탈퇴
	@Override
	public int remove(String userId) throws Exception{
		return userDao.remove(userId);
	}
	
	//회원 정보 보기 (마이 페이지)
	@Override
	public User findUser(String userId) throws Exception{
		return userDao.findUser(userId);
	}
	
	//전체 회원 정보 보기 (관리자 페이지)
	@Override
	public List<User> findUserList()throws Exception{
		return userDao.findUserList();
	}

	//아이디 중복 확인
	@Override
	public boolean isDuplicateId(String userId) throws Exception{
		boolean isExist = userDao.isExistUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
}















