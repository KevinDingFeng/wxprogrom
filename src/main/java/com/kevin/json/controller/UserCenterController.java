package com.kevin.json.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Card;
import com.kevin.entity.Integral;
import com.kevin.entity.PocketMoney;
import com.kevin.entity.PunchIn;
import com.kevin.entity.WXUser;
import com.kevin.service.CardService;
import com.kevin.service.IntegralService;
import com.kevin.service.PocketMoneyService;
import com.kevin.service.PunchInService;
import com.kevin.service.WXUserService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.UserInfoUtil;

@RestController
@RequestMapping(value = "/user_center/")
public class UserCenterController {
	
	@Autowired
	private WXUserService userService;
	@Autowired
	private CardService cardService;
	@Autowired
	private IntegralService integralService;
	
	@Autowired
	private PocketMoneyService pocketMoneyService;
	@Autowired
	private PunchInService punchInService;
//	@Autowired
//	private RedisUtil redisUtil;
	/**
	 * 个人中心
	 * 	用户信息
	 * 	卡信息
	 * 	总积分
	 * 	总零钱
	 * 	今日是否已签到
	 * @param shopId
	 * @param userId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Object index(HttpServletRequest request
			) {
		String token = request.getHeader("token");
		System.out.println("UserCenterController index token : " + token);
//		if(!redisUtil.exists(token)) {
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		
//		String shopIdStr = request.getHeader("shopId");
		String shopIdStr = "1";
		System.out.println("UserCenterController index shopId = " + shopIdStr);
//		if(shopIdStr == null) {
//			return JsonUtils.getFailJSONObject("invalid shopId");
//		}
		Long shopId = Long.parseLong(shopIdStr);
		Long userId = UserInfoUtil.getUserId(token);
		if(userId == null) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		System.out.println("UserCenterController index userId = " + userId);
		
		JSONObject j = new JSONObject();
		WXUser user = userService.findById(userId);
		j.put("user", user);//用户信息
		Card card = cardService.findByUserIdAndShopId(userId, shopId);
		j.put("card", card);//卡信息
		List<Integral> inteList = integralService.findByShopIdAndUserId(shopId, userId);
		if(inteList != null && inteList.size() > 0) {
			int intes = 0;
			for(Integral i : inteList) {
				intes += i.getNum();
			}
			j.put("totalIntes", intes);//总积分
		}
		
		List<PocketMoney> pmList = pocketMoneyService.findByShopIdAndUserId(shopId, userId);
		if(pmList != null && pmList.size() > 0) {
			BigDecimal totalAmount = BigDecimal.ZERO;
			for(PocketMoney pm : pmList) {
				totalAmount = totalAmount.add(pm.getAmount());
			}
			j.put("totalAmount", totalAmount);//总零钱
		}
		Date today = new Date(System.currentTimeMillis());
		PunchIn pi = punchInService.findByShopIdAndUserIdAndInvalidDate(shopId, userId, today);
		j.put("signed", pi == null ? false : true);//今日是否已签到
		
		return JsonUtils.getSuccessJSONObject(j);
	}
}
