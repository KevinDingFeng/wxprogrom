package com.kevin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.dao.UserDao;
import com.kevin.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User save(User user) {
		return userDao.save(user);
	}
	
	public User findByOpenId(String openId) {
		return userDao.findByOpenId(openId);
	}
}
