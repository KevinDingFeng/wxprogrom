package com.kevin.json.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Activity;
import com.kevin.entity.Good;
import com.kevin.entity.Shop;
import com.kevin.service.ActivityService;
import com.kevin.service.GoodService;
import com.kevin.service.ShopService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.RedisUtil;

@RestController
@RequestMapping(value = "/index/")
public class IndexController {
	
	@Autowired
	private GoodService goodService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private RedisUtil redisUtil;
	/**
	 * 首页
	 * 	商家信息
	 * 		banner图
	 * 	秒杀商品信息
	 * 	推荐商品信息
	 * 	活动信息一个
	 * @param shopId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Object index(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("IndexController index token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("IndexController index shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		JSONObject j = new JSONObject();
		Shop shop = shopService.findById(shopId);
		j.put("shop", shop);//商家信息
		
		Pageable pageable = new PageRequest(1, 10);
		Page<Good> pages = goodService.findAll(goodService.generateSpecification(Good.Type.Activity), pageable);
		List<Good> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		j.put("list", list);//推荐商品信息
		
		List<Good> gs = goodService.findByType(Good.Type.Second);
		if(gs != null && gs.size() > 0) {
			Good g = gs.get(0);
			j.put("second", g);//秒杀商品信息
		}
		
		pageable = new PageRequest(1, 1);
		Page<Activity> activity = activityService.findAll(pageable);
		if(activity != null) {
			List<Activity> as = activity.getContent();
			if(as != null && as.size() > 0) {
				Activity a = as.get(0);
				j.put("activity", a);//活动信息一个
			}
		}
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	
	/**
	 * 接口列表
	 * @return
	 */
	@RequestMapping(value = "/interface", method = RequestMethod.GET)
	public String index() {
		return "interface";
	}
}
