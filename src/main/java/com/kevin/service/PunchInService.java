package com.kevin.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.PunchInDao;
import com.kevin.entity.PunchIn;

@Service
@Transactional(readOnly = false)
public class PunchInService {
	
	@Autowired
	private PunchInDao punchInDao;

	public List<PunchIn> findAll(){
		return punchInDao.findAll();
	}

	/**
	 * 返回一个默认的签到实体
	 * @param shopId
	 * @return
	 */
	public PunchIn getOne(Long shopId) {
		PunchIn pi = new PunchIn();
		pi.setShopId(shopId);
		pi.setUserId(1L);//TODO
		pi.setInvalidDate(new Date(System.currentTimeMillis()));
		return pi;
	}

	public int getNumberInDateRange(Date begin, Date end) {
		return punchInDao.getNumInDateRange(begin, end);
	}

	public PunchIn save(PunchIn pi) {
		return punchInDao.saveAndFlush(pi);
	}

	public PunchIn findByShopIdAndUserIdAndInvalidDate(Long shopId, Long userId, Date date) {
		return punchInDao.findByShopIdAndUserIdAndInvalidDate(shopId, userId, date);
	}
	
}
