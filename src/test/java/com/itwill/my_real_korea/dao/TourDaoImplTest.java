package com.itwill.my_real_korea.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.Tour;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TourDaoImplTest {
	
	@Autowired
	private TourDao tourDao;

	@Test
	void testInsertTour() throws Exception{
		int rowCount=tourDao.insertTour(new Tour(0, "제주", 1, 2, 10, "제주공", 100000, "제주자유여행","테스트입니다", 0, null, null));
		assertEquals(rowCount,1);
	}
	
	@Disabled
	void testUpdateTour() {
		fail("Not yet implemented");
	}
	
	@Disabled
	void testSelectAll() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectByToNo() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectByKeyword() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectByCityNo() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectByToType() {
		fail("Not yet implemented");
	}

	@Disabled
	void testDeleteTour() {
		fail("Not yet implemented");
	}

}