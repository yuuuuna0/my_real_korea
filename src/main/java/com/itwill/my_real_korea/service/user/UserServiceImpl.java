package com.itwill.my_real_korea.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.user.UserAddInfoDao;
import com.itwill.my_real_korea.dao.user.UserDao;
import com.itwill.my_real_korea.dao.user.UserImgDao;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.dto.user.UserAddInfo;
import com.itwill.my_real_korea.dto.user.UserImg;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserImgDao userImgDao;
	@Autowired
	private UserAddInfoDao userAddInfoDao;
	@Autowired
	public EmailService emailService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServiceImpl() throws Exception {
		
	}
	
	//1. 회원 가입
	@Override
	public int create(User user) throws ExistedUserException, Exception {
	    try {
	        // 비밀번호 유효성 검증
	        validatePassword(user.getPassword());
	    } catch (Exception e) {
	        // Swagger에서 반환하는 결과 코드를 2로 설정
	    	throw new Exception(e.getMessage(), new RuntimeException(e.getMessage()));
	    }
	    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    // 사용자 등록 전에 중복 확인
	    boolean existedUser = userDao.isExistUser(user.getUserId());
	    if (existedUser) {
	        throw new ExistedUserException("이미 등록된 사용자입니다.");
	    }
	    // 회원가입
	    userDao.create(user);
	    // mail_key 업데이트
	    userDao.updateMailKey(user);
	    // userAddInfo 생성
	    UserAddInfo userAddInfo = new UserAddInfo("", 0, 0, user.getUserId());
	    userAddInfoDao.createUserAddInfo(userAddInfo);
	    // userImg 생성
	    UserImg userImg = new UserImg(0, "defaultImg.png", user.getUserId());
	    userImgDao.createUserImg(userImg);
	    return 1;
	}
	
	
	//2. 회원 정보 보기 (마이 페이지)
	@Override
	public User findUser(String userId) throws Exception{
		return userDao.findUser(userId);
	}
	
	//3. 전체 회원 정보 보기 (관리자 페이지)
	@Override
	public List<User> findUserList()throws Exception{
		return userDao.findUserList();
	}
	
	//4. 회원 정보 수정
	@Override
	public int update(User user)throws Exception{
	    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		return userDao.update(user);
	}
	
	//5. 회원 탈퇴
	@Override
	public int remove(String userId) throws Exception{
		return userDao.remove(userId);
	}
	
	
	//11. 아이디 중복 체크 (회원 가입(회원 존재 여부 확인))
	@Override
	public int countExistId(String userId) throws Exception {
		int existCount = 0;
		if(userDao.isExistUser(userId)) {
			existCount = 1;
		}
		return existCount;
	}
	
	//12. 로그인 (비밀번호 일치 여부 확인)
	@Override
	public User login(String userId, String password) throws Exception, UserNotFoundException, PasswordMismatchException {
	    User user = userDao.findUser(userId);
	    if (user == null) {
	        throw new UserNotFoundException(userId + " 는 존재하지 않는 아이디입니다.");
	    }
	    
	    //저장된 비밀번호와 암호화된 비밀번호를 비교
	    if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
	        throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
	    }
	    return user;
	}
	
	
	//12-1. 비밀번호 유효성 검사
	@Override
	public boolean validatePassword(String password) throws Exception {
	    if (password == null || password.isEmpty()) {
	        throw new Exception("비밀번호를 입력해주세요.");
	    }
	    if (password.matches("(.)\\1{2,}") 
	    		|| password.matches(".*(\\d)\\1{2,}.*") 
	    		|| password.matches(".*([a-zA-Z])\\1{2,}.*") 
	    		|| password.matches(".*(!|@|#|\\$|%|\\^|&|\\*|\\(|\\)).*\\1{2,}.*")) {
	        throw new Exception("같은 문자를 연속으로 3개 이상 사용할 수 없습니다.");
	    }
	    if (password.length() < 8 || password.length() > 12) {
	        throw new Exception("비밀번호는 8글자 이상 12글자 이하여야 합니다.");
	    }    
        if (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,12}$")) {
        	throw new Exception("비밀번호는 영문자, 숫자, 특수문자를 모두 포함해야 합니다.");
        }
	    return true;
	}
	
	
	//13. 아이디 찾기 (이메일, 이름으로 아이디 찾기)
	@Override
	public String findIdByEmailName(String email, String name) throws Exception {
		return userDao.findIdByEmailName(email,name);
	}
	
	//14. 비밀번호 찾기 (일치하는 회원 존재 여부 확인)
	@Override
	public int findIdByIdEmail(String userId, String email) throws Exception{
		boolean existIdEmail = userDao.isExistIdEmail(userId, email);
		int matchCount = 0;
		if(existIdEmail) {
			matchCount = 1;
		}else {
			matchCount = 0;
		}
		return matchCount;
	}
	
	//15. 비밀번호 찾기 (비밀번호 재설정, 임시 비밀번호 발송)
	public User sendTempPassword(String userId, String email) throws Exception {
		User user = userDao.findUser(userId);
	    String tempPassword = emailService.sendTempPassword(user.getEmail());
	    String encodedPassword = bCryptPasswordEncoder.encode(tempPassword);
	    user.setPassword(encodedPassword);
	    userDao.updatePassword(user);
	    return user;
	}
	
	
	//21. 메일 인증여부 확인
	public int findMailAuth(String userId) throws Exception {
		return userDao.findMailAuth(userId);
	}
	
	//22. 메일 인증번호 업데이트
    public int updateMailKey(User user) throws Exception {
        // 이메일 전송 및 인증번호 저장
        int authNum = emailService.sendAuth(user.getEmail());
        user.setMailKey(authNum);
        return userDao.updateMailKey(user);
    }
	
	//23. 메일 인증여부 업데이트
	public int updateMailAuth(User user) throws Exception {
		return userDao.updateMailAuth(user);
	}
	//24. 포인트 업데이트
	@Override
	public int updatePoint(User user) {
		return userDao.updatePoint(user);
	}


	
}
