package com.itwill.my_real_korea.service.tour;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.tour.TourReserve;
@SpringBootTest
class TourReserveServiceImplTest {
	@Autowired
	private TourReserveService tourReserveService;
	@Autowired
	private TourService tourService;

	void testInsertTourReserve() throws Exception{
		Tour tour=tourService.findTourWithCityByToNo(5);
		int rowCount=
				tourReserveService.insertTourReserve(new TourReserve(0, new Date(), 2, "예약할게요~", tour, "user1"));
		assertEquals(rowCount, 1);
	}
	
	void testUpdateTourReserve() throws Exception{
		int rowCount=tourReserveService.updateTourReserve(new TourReserve(6, new Date(), 10, "변경할게요", new Tour(), ""));
		assertEquals(rowCount, 1);
	}

	void testDeleteTourReserve() throws Exception{
		int rowCount=tourReserveService.deleteTourReserve(7);
		assertEquals(rowCount, 1);
	}

	void testFindTourReserveWithTourByToRsNo() throws Exception{
		TourReserve tourReserve=tourReserveService.findTourReserveWithTourByToRsNo(6);
		System.out.println(tourReserve);
	}

	void testFindAllTourReservewithTourByUserId() throws Exception{
		List<TourReserve> tourReserveList=tourReserveService.findAllTourReservewithTourByUserId("user1");
		for (TourReserve tourReserve : tourReserveList) {
			System.out.println(tourReserve);
		}
	}

	@Test
	void testDeleteAllTourReserveByUserId() throws Exception{
		tourReserveService.deleteAllTourReserveByUserId("admin");
	}

}
