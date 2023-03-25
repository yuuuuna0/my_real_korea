package com.itwill.my_real_korea.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.dao")
class NoticeDaoImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
