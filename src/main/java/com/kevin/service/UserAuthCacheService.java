package com.kevin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.UserAuthCacheDao;
import com.kevin.entity.UserAuthCache;

@Service
@Transactional(readOnly = false)
public class UserAuthCacheService {
	
	@Autowired
	private UserAuthCacheDao cacheDao;

	public UserAuthCache save(UserAuthCache userAuthCache) {
		return cacheDao.save(userAuthCache);
	}
	
}
