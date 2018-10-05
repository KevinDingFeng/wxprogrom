package com.kevin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Integral;

@Repository
public interface IntegralDao extends JpaRepository<Integral, Long>, JpaSpecificationExecutor<Integral> {

	List<Integral> findByShopIdAndUserId(Long shopId, Long userId);

}
