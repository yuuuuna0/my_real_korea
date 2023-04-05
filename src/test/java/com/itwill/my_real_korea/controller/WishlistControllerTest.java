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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.wishlist.WishlistService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class WishlistControllerTest {

	protected MockHttpSession session;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	WishlistService wishlistService;
	
	@Test
	void testWishlist() throws Exception {
		
		session = new MockHttpSession();
		String sUserId = "KIM";
		session.setAttribute("sUserId", sUserId);
		
		List<Wishlist> wishlistList = new ArrayList<>();
		wishlistList.add(new Wishlist(1, sUserId, new Ticket(1, sUserId, null, 0, sUserId, sUserId, 0, null), null));
		wishlistList.add(new Wishlist(2, sUserId, null, new Tour(2, sUserId, 0, 0, 0, sUserId, 0, sUserId, sUserId, 0, null)));
		wishlistList.add(new Wishlist(3, sUserId, new Ticket(3, sUserId, null, 0, sUserId, sUserId, 0, null), null));
		
		
		given(wishlistService.selectAllWithTicketAndTour(sUserId)).willReturn(wishlistList);
		mockMvc.perform(get("/wishlist").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("wishlist"))
		.andDo(print());
		
		verify(wishlistService).selectAllWithTicketAndTour(sUserId);
		
	}

}
