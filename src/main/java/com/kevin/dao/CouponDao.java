package com.kevin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Coupon;

@Repository
public interface CouponDao extends JpaRepository<Coupon, Long> , JpaSpecificationExecutor<Coupon>{

	Page<Coupon> findByShopId(Long shopId, Pageable pageable);

	Page<Coupon> findByIdIn(List<Long> ids, Pageable pageable);

}
