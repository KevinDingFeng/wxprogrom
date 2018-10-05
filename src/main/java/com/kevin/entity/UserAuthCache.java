package com.kevin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户授权缓存
 * 	因为目前没有使用 redis ，先使用 mysql 测试
 * @author kevin
 *
 */
@Entity
@Table(name = "user_auth_cache")
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class UserAuthCache extends BaseEntity{

	private String token;
	private String userInfo;
	
	public UserAuthCache() {
		
	}
	public UserAuthCache(String token, String userInfo) {
		this.token = token;
		this.userInfo = userInfo;
	}
	
	
}
