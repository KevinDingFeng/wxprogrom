package com.kevin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和优惠券之前的绑定关系
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class UserCouponRel extends BaseEntity{
	
	public UserCouponRel() {
		
	}
	public UserCouponRel(Long userId, Long couponId) {
		this.userId = userId;
		this.couponId = couponId;
	}
	
	/**
	 * 优惠券 id
	 */
	private Long couponId;
	
	/**
	 * 微信用户 id
	 */
	private Long userId;

}
