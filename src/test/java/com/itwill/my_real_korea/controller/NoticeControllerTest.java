package com.itwill.my_real_korea.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.service.notice.NoticeService;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class NoticeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	NoticeService noticeService;

	@Test
	void testNotice_list() throws Exception{
		PageMakerDto<Notice> noticeList = new PageMakerDto<Notice>();
		
		List<Notice> notices = new ArrayList<Notice>();
		notices.add(new Notice(1, null, null, null, 0, null, null));
		notices.add(new Notice(2, null, null, null, 0, null, null));
		notices.add(new Notice(3, null, null, null, 0, null, null));
		
		noticeList.setItemList(notices);
		noticeList.setPageMaker(new PageMaker(1, 10));
		noticeList.setTotRecordCount(3);
		
		given(noticeService.selectAll(1)).willReturn(noticeList);
		
		mockMvc.perform(get("/notice_list"))
		.andExpect(status().isOk())
		.andExpect(view().name("notice_list"))
		.andDo(print());
		
		verify(noticeService).selectAll(1);
	}

	@Test
	void testNotice_write_form() {
	}

	@Test
	void testNotice_modify_form() {
	}

}