package com.itwill.my_real_korea.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.Notice;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class NoticeDaoImplTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Disabled
	@Test
	void testInsertNotice() throws Exception{
		int rowCount = noticeDao.insertNotice(new Notice(0, "공지테스트1", "내용테스트1", null, 0, "이미지1.png","kms1"));
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		noticeDao.selectByNo(1);
	}

	@Disabled
	void testSelectAll() {
		fail("Not yet implemented");
	}

	@Disabled
	void testDeleteNotice() {
		fail("Not yet implemented");
	}

	@Disabled
	void testUpdateNotice() {
		fail("Not yet implemented");
	}

	@Disabled
	void testIncreaseReadCount() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectNoticeCount() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectSearchCount() {
		fail("Not yet implemented");
	}

	@Disabled
	void testSelectSearchNoticeList() {
		fail("Not yet implemented");
	}

}
