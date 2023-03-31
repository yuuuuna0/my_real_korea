package com.itwill.my_real_korea.service.city;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.mapper.CityMapper;
@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class CityServiceImplTest {
	@Autowired
	private CityService cityService;

	void testInsertCity() throws Exception{
		City newCity=new City(0,"인천",10,10);
		int rowCount=cityService.insertCity(newCity);
		assertEquals(rowCount, 1);
	}

	@Test
	void testFindByCityNo() throws Exception{
		System.out.println("3번 도시:" +cityService.findByCityNo(3));
		System.out.println("6번 도시:" +cityService.findByCityNo(6));
	}

	void testSelectAllCity() throws Exception{
		List<City> cityList=cityService.findAllCity();
		for (City city : cityList) {
			System.out.println(city);
		}
	}

}
