package com.itwill.my_real_korea.dao.location;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.Location;
import com.itwill.my_real_korea.mapper.LocationMapper;

@Repository
public class LocationDaoImpl implements LocationDao {
	@Autowired
	private LocationMapper locationMapper;

	@Override
	public Location findByToNo(int toNo) throws Exception {
		return locationMapper.findByToNo(toNo);
	}

	@Override
	public Location findByTiNo(int tiNo) throws Exception {
		return locationMapper.findByTiNo(tiNo);
	}


}
