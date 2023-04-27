package com.itwill.my_real_korea.service.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dao.location.LocationDao;
import com.itwill.my_real_korea.dto.Location;

@Repository
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationDao locationDao;

	@Override
	public Location findByToNo(int toNo) throws Exception {
		return locationDao.findByToNo(toNo);
	}

	@Override
	public Location findByTiNo(int tiNo) throws Exception {
		return locationDao.findByTiNo(tiNo);
	}


}
