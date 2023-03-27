package com.itwill.my_real_korea.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dto.Notice;

@SpringBootApplication
@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class NoticeServiceImplTest {

	@Autowired
	private NoticeService noticeService;
	
	@Disabled
	@Test
	void testInsertNotice() throws Exception {
		int rowCount = noticeService.insertNotice(new Notice(0, "공지S테스트1", "내용S테스트1", null, 0, "이미지S1.png","kms1"));
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		assertNotNull(noticeService.selectByNo(3));
		System.out.println(noticeService.selectByNo(3));
	}
	@Disabled
	@Test
	void testSelectAllInt() throws Exception {
		assertNotNull(noticeService.selectAll(1));
		System.out.println(noticeService.selectAll(1));
	}
	@Disabled
	@Test
	void testSelectSearchNoticeListIntString() throws Exception {
		assertNotNull(noticeService.selectSearchNoticeList(1, "수정"));
		System.out.println(noticeService.selectSearchNoticeList(1, "수정"));
	}
	@Disabled
	@Test
	void testGetTitleString() throws Exception {
		assertNotNull(noticeService.getTitleString(noticeService.selectByNo(2)));
		System.out.println(noticeService.getTitleString(noticeService.selectByNo(2)));
	}
	@Disabled
	@Test
	void testSelectAllIntInt() throws Exception {
		assertNotNull(noticeService.selectAll(1,10));
		System.out.println(noticeService.selectAll(1,10));
	}
	@Disabled
	@Test
	void testDeleteNotice() throws Exception {
		assertEquals(noticeService.deleteNotice(5), 1);
	}
	@Disabled
	@Test
	void testUpdateNotice() throws Exception {
		assertEquals(noticeService.updateNotice(new Notice(2, "공지S수정1", "내용S수정테스트1", null, 0, "이미지수정S1.png","kms2")), 1);
	}
	@Disabled
	@Test
	void testIncreaseReadCount() throws Exception {
		assertEquals(noticeService.increaseReadCount(3), 1);
	}
	@Disabled
	@Test
	void testSelectNoticeCount() throws Exception {
		assertNotNull(noticeService.selectNoticeCount());
		System.out.println(noticeService.selectNoticeCount());
	}
	@Disabled
	@Test
	void testSelectSearchCount() throws Exception {
		assertNotNull(noticeService.selectSearchCount("수정"));
		System.out.println(noticeService.selectSearchCount("수정"));
	}
	
	@Test
	void testSelectSearchNoticeListIntIntString() throws Exception {
		assertNotNull(noticeService.selectSearchNoticeList(1,10,"수정"));
		System.out.println(noticeService.selectSearchNoticeList(1,10,"수정"));
	}

}
