package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.IntegralDao;
import com.kevin.entity.Integral;

@Service
@Transactional(readOnly = false)
public class IntegralService {
	
	@Autowired
	private IntegralDao integralDao;

	public List<Integral> findAll(){
		return integralDao.findAll();
	}

	public List<Integral> findByShopIdAndUserId(Long shopId, Long userId) {
		return integralDao.findByShopIdAndUserId(shopId, userId);
	}
}
