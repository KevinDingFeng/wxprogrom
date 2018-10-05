package com.kevin.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kevin.entity.PunchIn;

@Repository
public interface PunchInDao extends JpaRepository<PunchIn, Long>, JpaSpecificationExecutor<PunchIn> {

	@Query("select count(p.id) as n from PunchIn p where p.creation >= ?1 and p.creation <= ?2")
	int getNumInDateRange(Date begin, Date end);

	PunchIn findByShopIdAndUserIdAndInvalidDate(Long shopId, Long userId, Date date);

}
