package com.itwill.my_real_korea.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
//@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	
	@Test
	void init() {
		System.out.println(userDao);
	}
	
	@Test
	void isMatchPassword() throws Exception {
		System.out.println(userDao.isMatchPassword("admin","admin0000"));
	}
	
	/*
	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}

	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	void testFindUserList() throws Exception {
		System.out.println(userDao.findUserList());
	}


}
