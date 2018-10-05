package com.kevin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和会员卡之间的绑定关系
 * @author kevin
 *
 */
@Entity
@Table
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class UserCardRel extends BaseEntity{

	/**
	 * 会员卡 id
	 */
	private Long cardId;
	
	/**
	 * 微信用户 id
	 */
	private Long userId;
}
