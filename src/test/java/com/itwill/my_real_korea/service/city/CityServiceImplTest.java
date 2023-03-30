package com.itwill.my_real_korea.service.city;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.mapper.CityMapper;
@SpringBootTest
@MapperScan(basePackageClasses = CityMapper.class)
class CityServiceImplTest {
	@Autowired
	private CityDao cityDao;

	void testInsertCity() throws Exception{
		City newCity=new City(0,"인천",10,10);
		int rowCount=cityDao.insertCity(newCity);
		assertEquals(rowCount, 1);
	}

	void testFindByCityNo() throws Exception{
		System.out.println("3번 도시:" +cityDao.findByCityNo(3));
		System.out.println("6번 도시:" +cityDao.findByCityNo(6));
	}

	@Test
	void testSelectAllCity() throws Exception{
		List<City> cityList=cityDao.selectAllCity();
		for (City city : cityList) {
			System.out.println(city);
		}
	}

}
