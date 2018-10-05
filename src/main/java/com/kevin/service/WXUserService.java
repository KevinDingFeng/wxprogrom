package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.WXUserDao;
import com.kevin.entity.WXUser;

@Service
@Transactional(readOnly = false)
public class WXUserService {

	@Autowired
	private WXUserDao wxUserDao;

	public List<WXUser> findAll() {
		return wxUserDao.findAll();
	}

	public WXUser save(WXUser user) {
		return wxUserDao.save(user);
	}

	public WXUser findByOpenId(String openId) {
		return wxUserDao.findByOpenId(openId);
	}

	public WXUser findById(Long id) {
		return wxUserDao.findById(id);
	}
	
}
