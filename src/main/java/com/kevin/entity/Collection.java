package com.kevin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收藏
 * 	针对商品
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class Collection extends BaseEntity{

	/**
	 * 商店 id
	 */
	private Long shopId;
	
	/**
	 * 商品 id
	 */
	private Long goodId;
	
	/**
	 * 微信用户 id
	 */
	private Long userId;
}
