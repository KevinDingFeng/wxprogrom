package com.kevin.json.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.Prize;
import com.kevin.entity.PunchIn;
import com.kevin.service.PrizeService;
import com.kevin.service.PunchInService;
import com.kevin.utils.JsonUtils;

@RestController
@RequestMapping(value = "/punch_in_json/")
public class PunchInController {

	@Autowired
	private PunchInService punchInService;
	@Autowired
	private PrizeService prizeService;
//	@Autowired
//	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public Object sign(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("PunchInController sign token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		
//		String shopIdStr = request.getHeader("shopId");
		String shopIdStr = "1";
		System.out.println("PunchInController sign shopId = " + shopIdStr);
//		if(shopIdStr == null) {
//			return JsonUtils.getFailJSONObject("invalid shopId");
//		}
		Long shopId = Long.parseLong(shopIdStr);
		PunchIn pi = punchInService.getOne(shopId);
		
		Date end = new Date(System.currentTimeMillis());
		Date begin = new Date(end.getTime() - 604800l);
		int num = punchInService.getNumberInDateRange(begin, end);
		
		Prize p = prizeService.getOneForPunchIn(num);
		pi.setLuckDrawn(true);
		pi = punchInService.save(pi);
		JSONObject j = new JSONObject();
		j.put("prize", p);
		j.put("result", pi);
		
		return JsonUtils.getSuccessJSONObject(j);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(HttpServletRequest request) {

		String token = request.getHeader("token");
		System.out.println("PunchInController list token : " + token);
//		if(!redisUtil.exists(token)) {TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		
		List<PunchIn> list = punchInService.findAll();
		return JsonUtils.getSuccessJSONObject(JSONObject.toJSON(list));
	}
}