package com.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.UserAuthCache;

@Repository
public interface UserAuthCacheDao extends JpaRepository<UserAuthCache, Long>, JpaSpecificationExecutor<UserAuthCache> {

}
