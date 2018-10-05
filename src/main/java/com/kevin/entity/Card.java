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
 * 会员卡
 * 		指定出各家商铺可以允许办理的会员卡信息
 * 		会员卡和微信用户绑定的信息，存到另外的表中
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class Card extends BaseEntity{
	
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
	 * 描述信息
	 */
	@Column(nullable = true, length = 256)
	private String context;
	
	/**
	 * 办卡的价格
	 */
	private BigDecimal price;
	
	/**
	 * 卡类型：黄金卡、白金卡、砖石卡
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type;
	
	public static enum Type{
		Gold("黄金"), Platinum("白金"), Diamonds("钻石");
		
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
