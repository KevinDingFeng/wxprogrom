package com.kevin.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 商店
 * @author kevin
 *
 */
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@Data
public class Shop extends BaseEntity{

//	/**
//	 * 商店 id
//	 */
//	private Long shopId;
	
	/**
	 * 商店名称
	 */
	@Column(nullable = true, length = 64)
	private String title;
	
	/**
	 * 商店拼音简写
	 */
	@Column(nullable = true, length = 64)
	private String simplePY;
	
	/**
	 * 商店LOGO
	 */
	@Column(nullable = true, length = 64)
	private String logoImg;
	
	/**
	 * 描述信息
	 */
	@Column(nullable = true, length = 256)
	private String context;
	
	/**
	 * 背景图片
	 */
	@Column(nullable = true, length = 64)
	private String bgImg;
	
	/**
	 * 联系方式
	 */
	@Column(nullable = true, length = 64)
	private String telephone;

	/**
	 * 地址
	 */
	@Column(nullable = true, length = 256)
	private String address;

	/**
	 * 纬度
	 */
	private BigDecimal latitude;
	
	/**
	 * 经度
	 */
	private BigDecimal longitude;
	
	
	/**
	 * 轮播图
	 */
	@Column(nullable = true, length = 256)
	private String banners;
	
}
