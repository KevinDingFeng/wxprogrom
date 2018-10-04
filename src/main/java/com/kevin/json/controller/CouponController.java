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
import com.kevin.entity.Coupon;
import com.kevin.service.CouponService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.UserInfoUtil;

@RestController
@RequestMapping(value = "/coupon_json/")
public class CouponController {

	@Autowired
	private CouponService couponService;
//	@Autowired
//	private RedisUtil redisUtil;
	
	/**
	 * 获取积分商城展示的优惠券信息
	 * @param shopId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/integral", method = RequestMethod.GET)
	public Object integral(HttpServletRequest request,  @RequestParam(value ="page") int page) {
		String token = request.getHeader("token");
		System.out.println("CouponController integral token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("CouponController integral shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Coupon> pages = couponService.findAll(pageable);
		Page<Coupon> pages = couponService.findByShopId(shopId, pageable);
		List<Coupon> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		
		JSONObject j = new JSONObject();
		j.put("list", list);
		j.put("currentPage", page);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	/**
	 * 获取优惠券信息
	 * @param shopId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request, 
			@RequestParam(value ="page") int page) {
		String token = request.getHeader("token");
		System.out.println("CouponController list token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		String shopIdStr = request.getHeader("shopId");
		System.out.println("CouponController list shopId = " + shopIdStr);
		if(shopIdStr == null) {
			return JsonUtils.getFailJSONObject("invalid shopId");
		}
		Long shopId = Long.parseLong(shopIdStr);
		Long userId = UserInfoUtil.getUserId(token);
		if(userId == null) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		System.out.println("CouponController list userId = " + userId);
		
		Pageable pageable = new PageRequest(page, 10);
//		Page<Coupon> pages = couponService.findAll(pageable);
		Page<Coupon> pages = couponService.findByUserIdAndShopId(userId, shopId, pageable);
		List<Coupon> list = new ArrayList<>();
		if(pages != null) {
			list = pages.getContent();
		}
		
		JSONObject j = new JSONObject();
		j.put("list", list);
		j.put("currentPage", page);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	public Object exchange(HttpServletRequest request, @RequestParam(value ="id") Long id
			) {
		String token = request.getHeader("token");
		System.out.println("CouponController exchange token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		Long userId = UserInfoUtil.getUserId(token);
		if(userId == null) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		System.out.println("CouponController exchange userId = " + userId);
		couponService.saveRel(couponService.getDefaultRel(id, userId));
		
		JSONObject j = new JSONObject();
		return JsonUtils.getSuccessJSONObject(j);
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public Object list() {
//		List<Coupon> list = couponService.findAll();
//		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
//	}
}