package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.PocketMoneyDao;
import com.kevin.entity.PocketMoney;

@Service
@Transactional(readOnly = false)
public class PocketMoneyService {
	
	@Autowired
	private PocketMoneyDao pocketMoneyDao;

	public List<PocketMoney> findAll(){
		return pocketMoneyDao.findAll();
	}

	public List<PocketMoney> findByShopIdAndUserId(Long shopId, Long userId) {
		return pocketMoneyDao.findByShopIdAndUserId(shopId, userId);
	}

}
