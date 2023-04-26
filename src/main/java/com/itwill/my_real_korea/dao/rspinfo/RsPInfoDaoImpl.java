package com.itwill.my_real_korea.dao.rspinfo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.RsPInfo;
import com.itwill.my_real_korea.mapper.RsPInfoMapper;
@Repository
public class RsPInfoDaoImpl implements RsPInfoDao {

	private RsPInfoMapper rsPInfoMapper;
	
	public RsPInfoDaoImpl(RsPInfoMapper reservePersonInfoMapper) {
		this.rsPInfoMapper=reservePersonInfoMapper;
	}
	
	@Override
	public int insertRsPerson(RsPInfo rsPInfo) {
		return rsPInfoMapper.insertRsPerson(rsPInfo);
	}

	@Override
	public RsPInfo selectRsPersonByPNo(int pNo) {
		return rsPInfoMapper.selectRsPersonByPNo(pNo);
	}

}
