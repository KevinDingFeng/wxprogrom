package com.kevin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Prize;

@Repository
public interface PrizeDao extends JpaRepository<Prize, Long>, JpaSpecificationExecutor<Prize> {

	List<Prize> findByShopIdAndRemoved(Long shopId, boolean b);

}
