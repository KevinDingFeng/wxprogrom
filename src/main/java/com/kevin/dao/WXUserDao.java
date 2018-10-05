package com.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.WXUser;

@Repository
public interface WXUserDao extends JpaRepository<WXUser, Long> , JpaSpecificationExecutor<WXUser>{

	WXUser findByOpenId(String openId);

	WXUser findById(Long id);

}
