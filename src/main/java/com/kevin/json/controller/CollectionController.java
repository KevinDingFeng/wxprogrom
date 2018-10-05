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
import com.kevin.entity.Collection;
import com.kevin.service.CollectionService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.RedisUtil;

@RestController
@RequestMapping(value = "/collection_json/")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 商品列表
	 * @param shopId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request, @RequestParam(value ="page") int page) {
		String token = request.getHeader("token");
		System.out.println("CollectionController list token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("CollectionController list shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Collection> pages = collectionService.findAll(pageable);
		Page<Collection> pages = collectionService.findByShopId(shopId, pageable);
		List<Collection> list = new ArrayList<>();
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
//		List<Collection> list = collectionService.findAll();
//		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
//	}
}