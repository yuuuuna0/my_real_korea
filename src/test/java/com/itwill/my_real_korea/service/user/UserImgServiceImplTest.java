package com.itwill.my_real_korea.service.user;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.UserImg;

@SpringBootTest
@Transactional
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class UserImgServiceImplTest {
	@Autowired
	private UserImgService userImgService;
	
	@Test
	void testCreateUserImg() throws Exception {
		UserImg userImg = new UserImg(21,"new.jpg","admin");
		System.out.println(">> created : "+userImgService.createUserImg(userImg));
	}

	@Test
	void testUpdateUserImg() throws Exception {
		UserImg userImg = userImgService.findUserImg("admin");
		userImg.setUserImgUrl("change.jpg");
		System.out.println(">> updated : "+userImgService.updateUserImg(userImg));
	}

	@Test
	void testRemoveUserImg() throws Exception {
		int removeRowCount = userImgService.removeUserImg(11);
		System.out.println(">> removed rowCount : "+removeRowCount);
	}

	@Test
	void testFindUserImg() throws Exception {
		System.out.println(">> findUserImg : "+userImgService.findUserImg("admin"));
	}

}
