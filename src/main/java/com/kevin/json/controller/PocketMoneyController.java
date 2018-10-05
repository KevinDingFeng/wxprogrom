package com.kevin.json.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.PocketMoney;
import com.kevin.service.PocketMoneyService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.RedisUtil;

@RestController
@RequestMapping(value = "/pocket_money_json/")
public class PocketMoneyController {

	@Autowired
	private PocketMoneyService pocketMoneyService;
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request) {

		String token = request.getHeader("token");
		System.out.println("PocketMoneyController list token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		List<PocketMoney> list = pocketMoneyService.findAll();
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
	}
}