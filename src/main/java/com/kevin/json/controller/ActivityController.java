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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Activity;
import com.kevin.service.ActivityService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.RedisUtil;

@RestController
@RequestMapping(value = "/activity_json/")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request, @RequestParam(value ="type") String type, @RequestParam(value ="page") int page) {
		String token = request.getHeader("token");
		System.out.println("ActivityController list token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		
		
		String shopIdStr = request.getHeader("shopId");
		System.out.println("ActivityController list shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Activity> pages = activityService.findAll(pageable);
		Page<Activity> pages = activityService.findByShopId(shopId, pageable);
		List<Activity> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		
		JSONObject j = new JSONObject();
		j.put("list", list);
		j.put("currentPage", page);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public Object list() {
//		List<Activity> list = activityService.findAll();
//		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
//	}
}