package com.itwill.my_real_korea.service.rspinfo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.rspinfo.RsPInfoDao;
import com.itwill.my_real_korea.dto.RsPInfo;
@Service
public class RsPInfoServiceImpl implements RsPInfoService {
	private RsPInfoDao rsPInfoDao;
	
	public RsPInfoServiceImpl(RsPInfoDao rsPInfoDao) {
		this.rsPInfoDao=rsPInfoDao;
	}
	
	@Override
	public int insertRsPerson(RsPInfo rsPInfo) {
		return rsPInfoDao.insertRsPerson(rsPInfo);
	}

	@Override
	public RsPInfo selectRsPersonByPNo(int pNo) {
		return rsPInfoDao.selectRsPersonByPNo(pNo);
	}

}
