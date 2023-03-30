package com.itwill.my_real_korea.dao.wishlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class WishlistDaoImplTest {

	@Autowired
	private WishlistDao wishlistDao;
	
	@Disabled
	@Test
	void testSelectAll() {
		List<Wishlist> wishlistList = wishlistDao.selectAll("user1");
		assertNotNull(wishlistList);
		System.out.println(wishlistList);
	}

	@Disabled
	@Test
	void testSelectAllWithTicketAndTour() {
		List<Wishlist> wishlistList = wishlistDao.selectAllWithTicketAndTour("user1");
		assertNotNull(wishlistList);
		System.out.println(wishlistList);
	}

	@Disabled
	@Test
	void testSelectWishlistCount() {
		int rowCount = wishlistDao.selectWishlistCount("user2");
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testInsertTicketToWishlist() {
		Wishlist ticketWishlist = new Wishlist(0, "user1", 2, 0);
		int rowCount = wishlistDao.insertTicketToWishlist(ticketWishlist);
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testInsertTourToWishlist() {
		Wishlist ticketWishlist = new Wishlist(0, "user2", 0, 3);
		int rowCount = wishlistDao.insertTourToWishlist(ticketWishlist);
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testDeleteWishlist() {
		int rowCount = wishlistDao.deleteWishlist("user3");
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	
	@Test
	void testDeleteWishlistByNoAndId() {
		int rowCount = wishlistDao.deleteWishlistByNoAndId(3,"user2");
		assertEquals(rowCount, 1);
		System.out.println(rowCount);
	}

}
