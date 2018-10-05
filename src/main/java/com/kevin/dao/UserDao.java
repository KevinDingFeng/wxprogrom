package com.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public User findByOpenId(String openId);
}
