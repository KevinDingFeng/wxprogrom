package com.kevin.json.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.WXUser;
import com.kevin.service.WXUserService;
import com.kevin.utils.JsonUtils;
import com.kevin.utils.UserInfoUtil;

@RestController
@RequestMapping(value = "/wxuser_json/")
public class WXUserController {
	@Autowired
	private WXUserService wxUserService;
//	@Autowired
//	private RedisUtil redisUtil;
	
	@RequestMapping(method = RequestMethod.POST)
	public Object create(HttpServletRequest request, 
			@RequestParam(value ="name") String name, 
			@RequestParam(value ="telephone") String telephone) {
		String token = request.getHeader("token");
		System.out.println("WXUserController create token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		
		String shopId = request.getHeader("shopId");
		System.out.println("WXUserController create shopId = " + shopId);
		Long userId = UserInfoUtil.getUserId(token);
		if(userId == null) {
			return JsonUtils.getFailJSONObject("invalid token");
		}
		System.out.println("WXUserController create userId = " + userId);
		
		JSONObject j = new JSONObject();
		WXUser wxUser = wxUserService.findById(userId);
		wxUser.setName(name);
		wxUser.setTelephone(telephone);
		wxUser = wxUserService.save(wxUser);

		j.put("result", "success");
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("WXUserController list token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		
		String shopId = request.getHeader("shopId");
		System.out.println("WXUserController list shopId = " + shopId);
		List<WXUser> list = wxUserService.findAll();
		
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
		/*{
			"code":"200",
			"data":[
				{
					"birthday":"1992-04-08",
					"openId":"wx123456789",
					"name":"小强",
					"telephone":"18910739693",
					"id":1,
					"lastModified":"2018-06-02T08:20:35.000+0000",
					"type":"VVIP",
					"version":0,
					"creation":"2018-06-02T08:20:35.000+0000"
				},
				{
					"birthday":"1992-04-09",
					"openId":"wx987654321",
					"name":"大强",
					"telephone":"18996931073",
					"id":2,
					"lastModified":"2018-06-02T08:33:32.000+0000",
					"type":"VVIP",
					"version":0,
					"creation":"2018-06-02T08:33:32.000+0000"
				}
			],
			"message":"success"
		}*/
	}

}
