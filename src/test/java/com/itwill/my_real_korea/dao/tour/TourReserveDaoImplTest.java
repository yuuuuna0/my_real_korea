package com.itwill.my_real_korea.dao.tour;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourReserve;
@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TourReserveDaoImplTest {
	@Autowired
	private TourReserveDao tourReserveDao;
	
	void testInsertTourReserve() throws Exception{
		int rowCount=tourReserveDao.insertTourReserve(new TourReserve(0, new Date(), 3,"날짜 어케", new Tour(3, null, 0, 0, 0, null, 0, null, null, 0, null),"user2"));
		assertEquals(rowCount, 1);
	}

	void testUpdateTourReserve() throws Exception{
		int rowCount=tourReserveDao.updateTourReserve(new TourReserve(2,new Date(),5,"변경",new Tour(2, null, 0, 0, 0, null, 0, null, null, 0, null),"admin")); 
		assertEquals(rowCount, 1);
	}

	void testDeleteTourReserve() throws Exception{
		int rowCount=tourReserveDao.deleteTourReserve(1);
		assertEquals(rowCount, 1);
	}

	void testSelectByToRsNo() throws Exception{
		TourReserve tourReserve=tourReserveDao.selectByToRsNo(2);
		System.out.println(tourReserve);
	}

	void testSelectAllTourReserveByUserId() throws Exception{
		List<TourReserve> tourReserveList=tourReserveDao.selectAllTourReserveByUserId("user2");
		System.out.println(tourReserveList.size());
		for (TourReserve tourReserve : tourReserveList) {
			System.out.println(tourReserve);
		}
	}

	@Test
	void testDeleteAllTourReserveByUserId() throws Exception{
		int rowCount=tourReserveDao.deleteAllTourReserveByUserId("user2");
		System.out.println(rowCount);
	}

}
