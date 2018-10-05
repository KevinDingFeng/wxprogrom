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
 * 积分
 * 		来源包括签到、首页领奖等
 * @author kevin
 *
 */
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@Data
public class Integral extends BaseEntity{
	
	/**
	 * 额度
	 */
	private Integer num;
	
	/**
	 * 微信用户 id
	 */
	private Long userId;
	
	/**
	 * 商店 id
	 */
	private Long shopId;
	
	/**
	 * 途径，从什么途径获取到的零钱，包括：签到、抽奖、幸运号
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type ;
	
	public static enum Type{
		PunchIn("签到"), Drawn("抽奖"), Luck("幸运号");
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
}
