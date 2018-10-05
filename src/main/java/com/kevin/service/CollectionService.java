package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.CollectionDao;
import com.kevin.entity.Collection;

@Service
@Transactional(readOnly = false)
public class CollectionService {
	
	@Autowired
	private CollectionDao collectionDao;

	public List<Collection> findAll(){
		return collectionDao.findAll();
	}

	public Page<Collection> findAll(Pageable pageable) {
		return collectionDao.findAll(pageable);
	}

	public Page<Collection> findByShopId(Long shopId, Pageable pageable) {
		return collectionDao.findByShopId(shopId, pageable);
	}
	
}
