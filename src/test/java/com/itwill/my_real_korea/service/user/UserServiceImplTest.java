package com.itwill.my_real_korea.service.user;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.User;

@Transactional
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	
	@Test
	void testCreate() throws Exception {
		User user = new User("test2", "test1111", "테스트", "테스트", "011-1111-1111", "test1@gmail.com", new Date(), "테스트", 0, 0, 1);
		System.out.println(userService.create(user));
	}
	
//	@Test
	void testLogin() throws Exception {
		int loginRowCount = userService.login("admin", "admin0000");
		System.out.println("user loginRowCount :"+loginRowCount);
	}

	@Test
	void testFindUser() throws Exception {
		System.out.println(userService.findUser("admin"));
	}

//	@Test
	void testIsDuplicateId() throws Exception {
		System.out.println(userService.isDuplicateId("test1"));
		System.out.println(userService.isDuplicateId("test2"));
	}

	
//	@Test
	void testUpdate() throws Exception {
		User user = userService.findUser("test1");
		user.setPassword("test1112");
		user.setNickname("테스트변경");
		user.setPhone("011-1111-1112");
		user.setEmail("test1@naver.com");
		int updateRowCount = userService.update(user);
		System.out.println("user updateRowCount : "+updateRowCount);
	}

//	@Test
	void testFindUserList() throws Exception {
		System.out.println(userService.findUserList());
	}


//	@Test
	void testRemove() throws Exception {
		int removeRowCount = userService.remove("test1");
		System.out.println("user removeRowCount : "+removeRowCount);
	}
	
}

