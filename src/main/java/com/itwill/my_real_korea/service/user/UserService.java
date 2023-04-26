package com.itwill.my_real_korea.service.user;

import java.util.List;

import com.itwill.my_real_korea.dto.user.User;

public interface UserService {

	//1. 회원 가입
	int create(User user) throws Exception;
	//2. 회원 정보 보기 (마이 페이지)
	User findUser(String userId) throws Exception;
	//3. 전체 회원 정보 보기 (관리자 페이지)
	List<User> findUserList() throws Exception;
	//4. 회원 정보 수정
	int update(User user) throws Exception;
	//5. 회원 탈퇴
	int remove(String userId) throws Exception;
	
	//11. 아이디 중복 체크 (회원 가입(회원 존재 여부 확인))
	int countExistId(String userId) throws Exception;
	//12. 로그인 (비밀번호 일치 여부 확인)
	User login(String userId, String password) throws Exception;
	//12-1. 비밀번호 유효성 검사
	boolean validatePassword(String password) throws Exception;
	//13. 아이디 찾기 (이메일, 이름으로 아이디 찾기)
	String findIdByEmailName(String email, String name) throws Exception;
	//14. 비밀번호 찾기 (일치하는 회원 존재 여부 확인)
	int findIdByIdEmail(String userId, String email) throws Exception;
	//15. 비밀번호 찾기 (비밀번호 재설정, 임시 비밀번호 발송)
	User sendTempPassword(String userId, String email) throws Exception;
	
	//21. 메일 인증여부 확인
	int findMailAuth(String userId) throws Exception;
	//22. 메일 인증번호 업데이트
	int updateMailKey(User user) throws Exception;
	//23. 메일 인증여부 업데이트
	int updateMailAuth(User user) throws Exception;
	//24. 포인트 업데이트
	public int updatePoint(User user);
	
}