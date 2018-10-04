package com.kevin.json.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Card;
import com.kevin.service.CardService;
import com.kevin.utils.JsonUtils;

@RestController
@RequestMapping(value = "/card_json/")
public class CardController {

	@Autowired
	private CardService cardService;
//	@Autowired
//	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("CardController list token : " + token);
//		if(!redisUtil.exists(token)) { TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		List<Card> list = cardService.findAll();
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
	}
}