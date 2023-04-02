package com.itwill.my_real_korea.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.UserImg;

@Transactional
@SpringBootTest
class UserImgDaoImplTest {
	@Autowired
	private UserImgDao userImgDao;

	@Test
	void testCreateUserImg() throws Exception {
		UserImg createUserImg = new UserImg(0, "test1.png", "user1");
		System.out.println(">> created : "+userImgDao.createUserImg(createUserImg));
	}

	@Test
	void testUpdateUserImg() throws Exception {
		UserImg updateUserImg = new UserImg(0, "change1.png", "user1");
		System.out.println(userImgDao.updateUserImg(updateUserImg));
	}

	@Test
	void testRemoveUserImg() throws Exception {
		System.out.println(userImgDao.removeUserImg(11));
	}

	@Test
	void testFindUserImg() throws Exception {
		System.out.println(userImgDao.findUserImg("user2"));
	}

}
