package com.kevin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.UserCouponRel;

@Repository
public interface UserCouponRelDao extends JpaRepository<UserCouponRel, Long>, JpaSpecificationExecutor<UserCouponRel> {

	Page<UserCouponRel> findByUserId(Long userId, Pageable pageable);

}
