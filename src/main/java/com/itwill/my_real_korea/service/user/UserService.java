package com.itwill.my_real_korea.service.user;

import java.util.List;

import com.itwill.my_real_korea.dto.user.User;

public interface UserService {

	//회원 가입
	int create(User user) throws Exception;
	
	//아이디 중복체크
	boolean isDuplicateId(String userId) throws Exception;

	//로그인
	/*
	 *	0: 아이디 존재 안함
	 *	1: 패스워드 불일치
	 *	2: 로그인 성공
	 */
	int login(String userId, String password) throws Exception;

	//회원 정보 수정
	int update(User user) throws Exception;

	//회원 탈퇴
	int remove(String userId) throws Exception;

	//회원 정보 보기 (마이 페이지)
	User findUser(String userId) throws Exception;
	
	//전체 회원 정보 보기 (관리자 페이지)
	List<User> findUserList() throws Exception;



}