package com.kevin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.PocketMoney;

@Repository
public interface PocketMoneyDao extends JpaRepository<PocketMoney, Long>, JpaSpecificationExecutor<PocketMoney> {

	List<PocketMoney> findByShopIdAndUserId(Long shopId, Long userId);

}
