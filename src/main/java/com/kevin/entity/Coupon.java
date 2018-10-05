package com.kevin.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class Coupon extends BaseEntity{
	
	/**
	 * 商店 id
	 */
	private Long shopId;
	
	/**
	 * 商店名称
	 */
	@Column(nullable = true, length = 64)
	private String shopTitle;
	
	/**
	 * 商店拼音简写
	 */
	@Column(nullable = true, length = 64)
	private String shopSimplePY;
	
	/**
	 * 商店LOGO
	 */
	@Column(nullable = true, length = 64)
	private String shopLogoImg;
	
	/**
	 * 名称
	 */
	@Column(nullable = true, length = 64)
	private String title;
	
	/**
	 * 描述信息，使用说明
	 */
	@Column(nullable = true, length = 256)
	private String context;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;
	
	/**
	 * 失效日期
	 */
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date invalidDate;
}
