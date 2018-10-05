package com.kevin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Activity;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Long>, JpaSpecificationExecutor<Activity> {

	Page<Activity> findByShopId(Long shopId, Pageable pageable);

}
