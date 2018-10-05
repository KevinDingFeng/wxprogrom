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
 * 奖品、奖项
 * @author kevin
 *
 */
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@Data
public class Prize extends BaseEntity{

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
	 * 类型：积分、红包（零钱）、优惠券
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type ;
	
	public static enum Type{
		Integral("积分"), Pocket("红包"), Coupon("优惠券"), Other("其他");
		//超级会员，供定风内部人员使用
		
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
	 * 积分 额度
	 */
	private Integer integralNum;
	
	/**
	 * 红包 额度
	 */
	private BigDecimal pocketAmount;
	
	/**
	 * 优惠券 id
	 */
	private Long couponId;

	private boolean removed = false;
}
