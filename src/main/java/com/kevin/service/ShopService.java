package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.ShopDao;
import com.kevin.entity.Shop;

@Service
@Transactional(readOnly = false)
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;

	public Shop findById(Long id) {
//		List<Shop> list = shopDao.findAll();
//		shopDao.findAllById(ids)
		Shop p = shopDao.findOne(id);
		
		return p;
	}

	public Shop save(Shop shop) {
		return shopDao.save(shop);
	}
	
	public List<Shop> findAll(){
		return shopDao.findAll();
	}

}
