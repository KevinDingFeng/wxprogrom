package com.kevin.json.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Good;
import com.kevin.entity.Order;
import com.kevin.service.GoodService;
import com.kevin.service.OrderService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.RedisUtil;
import com.kevin.utils.UserInfoUtil;

@RestController
@RequestMapping(value = "/good_json/")
public class GoodController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private OrderService orderService;
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
		System.out.println("GoodController list token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("GoodController list shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Good> pages = goodService.findAll(pageable);
		Page<Good> pages = goodService.findByShopId(shopId, pageable);
		List<Good> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		
		JSONObject j = new JSONObject();
		j.put("list", list);
		j.put("currentPage", page);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object detail(HttpServletRequest request, @PathVariable("id") Long id) {

		String token = request.getHeader("token");
		System.out.println("GoodController detail token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		Good good = goodService.findById(id);
		
		JSONObject j = new JSONObject();
		j.put("detail", good);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	/**
	 * 获取积分商城展示的商品信息
	 * @param shopId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/integral", method = RequestMethod.GET)
	public Object integral(HttpServletRequest request, @RequestParam(value ="page") int page) {
		String token = request.getHeader("token");
		System.out.println("GoodController integral token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("GoodController integral shopIdStr = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Good> pages = goodService.findAll(pageable);
		Page<Good> pages = goodService.findByShopId(shopId, pageable);
		List<Good> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		
		JSONObject j = new JSONObject();
		j.put("list", list);
		j.put("currentPage", page);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	public Object exchange(HttpServletRequest request, @RequestParam(value ="id") Long id) {
		String token = request.getHeader("token");
		System.out.println("GoodController exchange token : " + token);
		if(!redisUtil.exists(token)) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		Long userId = UserInfoUtil.getUserId(token);
		if(userId == null) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		System.out.println("GoodController exchange userId = " + userId);
		Order order = orderService.getDefault(userId, id);
		order = orderService.save(order);
		
		JSONObject j = new JSONObject();
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public Object list() {
//		List<Good> list = goodService.findAll();
//		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
//	}
}