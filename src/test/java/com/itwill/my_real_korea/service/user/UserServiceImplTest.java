package com.itwill.my_real_korea.service.user;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.User;

@Transactional
@SpringBootTest
class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	void testCreate() throws Exception {
		User user = new User("test2", "test1111", "테스트", "테스트", "011-1111-1111", "test1@gmail.com", new Date(), "테스트", 0, 0, 1, null, null);
		System.out.println(">> created :"+userService.create(user));
	}
	
	@Test
	void testLogin() throws Exception {
		int loginRowCount = userService.login("admin", "admin0000");
		System.out.println("user loginRowCount :"+loginRowCount);
	}

	@Test
	void testIsDuplicateId() throws Exception {
		System.out.println(userService.isDuplicateId("test1"));
		System.out.println(userService.isDuplicateId("test2"));
	}

	@Test
	void testUpdate() throws Exception {
		User user = userService.findUser("user1");
		user.setPassword("user1112");
		user.setNickname("유저1");
		user.setPhone("011-1111-1112");
		user.setEmail("test1@naver.com");
		System.out.println(">> updated :"+userService.update(user));
	}
	
	@Test
	void testFindUser() throws Exception {
		System.out.println(">> findUser :"+userService.findUser("user1"));
	}

	@Test
	void testFindUserList() throws Exception {
		System.out.println(">> findUserList :"+userService.findUserList());
	}

	@Test
	void testRemove() throws Exception {
		int removeRowCount = userService.remove("test1");
		System.out.println(">> removed rowCount : "+removeRowCount);
	}
	
	@Test
	void testFindId() throws Exception {
		User user = new User();
		user.setEmail("test1@naver.com");
		user.setName("테스트");
		System.out.println(">> ID : "+userService.findIdByEmailName(user));
	}
	
}

