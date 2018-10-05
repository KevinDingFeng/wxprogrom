package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.ActivityDao;
import com.kevin.entity.Activity;

@Service
@Transactional(readOnly = false)
public class ActivityService {
	
	@Autowired
	private ActivityDao activityDao;

	public List<Activity> findAll(){
		return activityDao.findAll();
	}

	public Page<Activity> findAll(Pageable pageable) {
		return activityDao.findAll(pageable);
	}

	public Page<Activity> findByShopId(Long shopId, Pageable pageable) {
		return activityDao.findByShopId(shopId, pageable);
	}
	
}
