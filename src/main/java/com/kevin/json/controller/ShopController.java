package com.kevin.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Shop;
import com.kevin.service.ShopService;
import com.kevin.utils.JsonUtils;

@RestController
@RequestMapping(value = "/shop_json/")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	
	@RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
	public String create() {
		
//		Shop shop = new Shop();
//		shop.setName("无上密");
//		shop.setLogo("http://www.dingfengkj.com/img/1.png");
//		
//		shop = shopService.save(shop);
		JSONObject json = new JSONObject();
//		json.put("id", shop.getId());
//		json.put("name", shop.getName());
//		json.put("logo", shop.getLogo());
		
		JSONObject res = new JSONObject();
		res.put("data", json);
		return res.toJSONString();
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id) {
		Shop shop = shopService.findById(id);
		if(shop != null) {
			JSONObject json = new JSONObject();
			json.put("id", shop.getId());
//			json.put("name", shop.getName());
//			json.put("logo", shop.getLogo());
//			
			JSONObject res = new JSONObject();
			res.put("data", json);
			return res.toJSONString();
		}
		return "{\"data\":\"entity is null!\"}";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		List<Shop> list = shopService.findAll();
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
	}
	
}