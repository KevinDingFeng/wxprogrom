package com.kevin.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 签到、打卡
 * @author kevin
 *
 */
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@Data
public class PunchIn extends BaseEntity{

	/**
	 * 商店 id
	 */
	private Long shopId;
	
	/**
	 * 微信用户 id
	 */
	private Long userId;
	
	/**
	 * 日期
	 */
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date invalidDate = new Date(System.currentTimeMillis());
	
	/**
	 * 是否完成当天的抽奖
	 */
	private boolean luckDrawn = false;
}
