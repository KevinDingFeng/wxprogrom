package com.kevin.entity;

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
 * 活动
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class Activity extends BaseEntity{

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
	 * 图片
	 */
	@Column(nullable = true, length = 64)
	private String banner;
	
	/**
	 * 联系方式，在 type = 活动 时存在有效值
	 */
	@Column(nullable = true, length = 64)
	private String telephone;

	/**
	 * 地址，在 type = 活动 时存在有效值
	 */
	@Column(nullable = true, length = 256)
	private String address;
	
	/**
	 * type,新闻、活动
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type ;
	
	public static enum Type{
		News("新闻"), Activity("活动");
		
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
	
	/**
	 * 品牌
	 */
	@Column(nullable = true, length = 64)
	private String brand;
	
	
}
