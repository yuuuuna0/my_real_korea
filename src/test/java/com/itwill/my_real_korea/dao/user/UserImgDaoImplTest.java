package com.itwill.my_real_korea.dao.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.UserImg;

@Transactional
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class UserImgDaoImplTest {
	@Autowired
	private UserImgDao userImgDao;

	@Test
	void testCreateUserImg() throws Exception {
//		UserImg createUserImg = new UserImg(0, "test1.png", "user1");
//		System.out.println(userImgDao.createUserImg(createUserImg));
	    UserImg createUserImg = new UserImg();
	    createUserImg.setUserImgUrl("test1.png");
	    createUserImg.setUserId("user1");
	    int result = userImgDao.createUserImg(createUserImg);
	    System.out.println("result: " + result);
	    assertNotNull(createUserImg.getUserImgNo());
	}

//	@Test
	void testUpdateUserImg() throws Exception {
		UserImg updateUserImg = new UserImg(0, "change1.png", "user1");
		System.out.println(userImgDao.updateUserImg(updateUserImg));
	}

//	@Test
	void testRemoveUserImg() throws Exception {
		System.out.println(userImgDao.removeUserImg(11));
	}

	@Test
	void testFindUserImg() throws Exception {
		System.out.println(userImgDao.findUserImg("user2"));
	}

}
