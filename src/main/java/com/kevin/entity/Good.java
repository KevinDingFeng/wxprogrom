package com.kevin.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品
 * @author kevin
 *
 */
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@Data
public class Good extends BaseEntity{
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
	 * 商品名称
	 */
	@Column(nullable = true, length = 64)
	private String name;
	
	/**
	 * 轮播图
	 */
	@Column(nullable = true, length = 256)
	private String banners;
	
	/**
	 * 原价格
	 */
	private BigDecimal price;
	
	/**
	 * 现价
	 */
	private BigDecimal currentPrice;
	
	/**
	 * 描述信息
	 */
	@Column(nullable = true, length = 256)
	private String context;

	/**
	 * 分类，秒杀、团购、限时购、活动商品、普通商品
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type;
	
	public static enum Type{
		Second("秒杀"), Group("团购"), Limit("限时购"), Activity("活动商品"), Normal("普通商品");
		
		private String text;
		
		private Type(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		
		public static List<Type> getAllTypes(){
			return Arrays.asList(Type.values());
		}
	}
}
