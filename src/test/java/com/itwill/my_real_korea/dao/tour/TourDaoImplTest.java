package com.itwill.my_real_korea.dao.tour;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;


//@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class TourDaoImplTest {
	@Autowired
	private TourDao tourDao;
	
	void testInsertTour() throws Exception{
		int rowCount=tourDao.insertTour(new Tour(0,"테스트2",1,1,10,"테스트2",3000,"테스트입니다2","노티스입니다2",0,new City(1, null, 0, 0)));
		assertEquals(rowCount, 1);
	}

	void testUpdateTour() throws Exception{
		int rowCount=tourDao.updateTour(new Tour(6,"변경",2,2,5,"변경",50000,"변경입니다","변경",0,new City(1,null,0,0)));
		assertEquals(rowCount, 1);
	}

	void testSelectAll() throws Exception{
		List<Tour> tourList=tourDao.selectAll();
		for (Tour tour : tourList) {
			System.out.println(tour.getToName());
		}		
	}

	void testSelectByToNo() throws Exception{
		Tour tour=tourDao.selectByToNo(4);
		System.out.println(tour);
	}
	
	@Test
	void testSelectByKeyword() throws Exception{
		List<Tour> tourList=tourDao.selectByKeyword("투어");
		System.out.println(tourList.size());
		for (Tour tour : tourList) {
			System.out.println(tour.toString());
		}
	}

	void testSelectByCityNo() throws Exception{
		List<Tour> tourList=tourDao.selectByCityNo(3);
		System.out.println(tourList.size());
	}

	void testSelectByToType() throws Exception{
		List<Tour> tourList=tourDao.selectByToType(2);
		System.out.println(tourList.size());
	}

	void testDeleteTour() throws Exception{
		int rowCount=tourDao.deleteTour(8);
		assertEquals(rowCount, 1);
	}

}
