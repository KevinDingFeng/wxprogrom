package com.kevin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kevin.common.BaseResponse;

@Component
public class UserInfoUtil {
	

	@Autowired
	private static RedisUtil redisUtil;
	
	public static Long getUserId(String token) {
		String result = redisUtil.get(token);
		if(result == null) {
			return null;
		}
		String[] res = result.split(BaseResponse.splitChar);
		if(res.length < 3) {
			return null;
		}
		Long userId = Long.parseLong(res[2]);
		return userId;
	}
}
