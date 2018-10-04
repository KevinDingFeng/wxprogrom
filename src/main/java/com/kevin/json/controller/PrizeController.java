package com.kevin.json.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Prize;
import com.kevin.service.PrizeService;
import com.kevin.utils.JsonUtils;

@RestController
@RequestMapping(value = "/prize_json/")
public class PrizeController {

	@Autowired
	private PrizeService prizeService;
//	@Autowired
//	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		List<Prize> list = prizeService.findAll();
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
	}
	
	@RequestMapping(value = "/prizes", method = RequestMethod.GET)
	public Object prizes(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("PrizeController prizes token : " + token);
//		if(!redisUtil.exists(token)) {
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
//		
//		String shopIdStr = request.getHeader("shopId");
		String shopIdStr = "1";
		System.out.println("PrizeController prizes shopId = " + shopIdStr);
//		if(shopIdStr == null) {
//			return JsonUtils.getFailJSONObject("invalid shopId");
//		}
		Long shopId = Long.parseLong(shopIdStr);
		List<Prize> list = prizeService.getPrizesByShopId(shopId);
		
		Random r = new Random();
		int res = r.nextInt(list.size());//中奖结果
		
		JSONObject j = new JSONObject();
		j.put("prizes", list);
		j.put("result", res);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
}