package com.kevin.auth.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.kevin.common.BaseResponse;
import com.kevin.entity.WXUser;
import com.kevin.service.WXUserService;
import com.kevin.utils.JsonUtils;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.exception.WxErrorException;

@RestController
@RequestMapping(value = "/kevin")
public class KevinAuthController {
	
	@Autowired
    private WxMaService wxService;
//	@Autowired
//	private UserAuthCacheService cacheService;
	@Autowired
	private WXUserService userService;
//	@Autowired
//	private RedisUtil redisUtil;
	

	@RequestMapping(value = "/login_status", method = RequestMethod.GET)
	public Object getLoginStatus(@RequestParam(value = "code") String code,
			@RequestParam(value = "signature") String signature, 
			@RequestParam(value = "rawData") String rawData, 
			@RequestParam(value = "encryptedData") String encryptedData, 
			@RequestParam(value = "iv") String iv) throws WxErrorException {
		if(StringUtils.isEmpty(code)) {
			return JsonUtils.getFailJSONObject("无效的code");
		}else {
			//存在有效的 code
			System.out.println("这里请求了一次code==========" + code);
			WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
			String sessionKey = session.getSessionKey();
			//通过openId sessionKey 生成3rd session 返回给客户端小程序
			String accessToken = UUID.randomUUID().toString();
//			cacheService.save(new UserAuthCache(accessToken, sessionKey + ":" + session.getOpenid()));
			
			// 用户信息校验
	        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
	        	return JsonUtils.getFailJSONObject("用户信息校验失败");
	        }
	     // 解密用户信息
	        WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
	        WXUser user = userService.findByOpenId(userInfo.getOpenId());
	        if(user == null || user.getId() == null) {
	        	user = new WXUser();
	        }
	        this.setCopyProperties(userInfo, user);
	        user = userService.save(user);
//	        redisUtil.set(accessToken, TODO
//	        		sessionKey + BaseResponse.splitChar + session.getOpenid() + BaseResponse.splitChar + user.getId(), 
//	        		BaseResponse.ex);//使用 redis 制作缓存，暂时使用数据库完成测试工作
	        System.out.println("accessToken : " + accessToken);
	        return JsonUtils.getSuccessJSONObject(accessToken);
		}
	}
//	wx.login({
//    success: function (res) {
//      var code = res.code;
//      wx.getUserInfo({
//        success: function (res) {
//          console.log(res.userInfo);
//          var iv = res.iv;
//          var encryptedData = res.encryptedData;
//          var signature = res.signature;
//          var rawData = res.rawData;
//
//          wx.request({
//            url: "https://www.dingfengkj.com/wx/kevin/login_status",//上传用户信息和登录用的code，获取token
//            data: {
//              code: code,
//              signature: signature,
//              rawData: rawData,
//              encryptedData: encryptedData,
//              iv: iv
//            },
//            success: function (res) {
//              if(res.data.code && res.data.code == "200"){
					//授权成功
//					console.log("token : " + res.data.data);//从后台获取的token，前端自己保存到全局变量中，备用；以后每次使用request都把该变量存入header变量
//				}
//            }
//          })
//
//        },
//        fail: function () {
//          _this.authSetting();
//        }
//      })
//    }
//  })
	@RequestMapping(value = "/check_token", method = RequestMethod.GET)
	public Object checkToken(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("KevinAuthController checkToken token : " + token);
		
//		if(redisUtil.exists(token)) { TODO
			return JsonUtils.getSuccessJSONObject();
//		}
//		return JsonUtils.getFailJSONObject("invalid token");
	}
	
	@RequestMapping(value = "/user_info", method = RequestMethod.GET)
	public Object userInfo(HttpServletRequest request) {
		String token = request.getHeader("token");
		System.out.println("KevinAuthController userInfo token : " + token);
		
//		String result = redisUtil.get(token);
//		if(result == null) { TODO
//			return JsonUtils.getFailJSONObject("invalid token");
//		}
		String result = "" + BaseResponse.splitChar + "oR2BG4xkgDb6IZPVaWsi_f_NfYoA";
		String[] res = result.split(BaseResponse.splitChar);
		if(res.length > 1) {
			WXUser user = userService.findByOpenId(res[1]);
	        if(user == null) {
	        	return JsonUtils.getFailJSONObject("invalid token");
	        }else {
	        	return JsonUtils.getSuccessJSONObject(user);
	        }
		}
		return JsonUtils.getSuccessJSONObject();
	}
//		wx.request({
//	      url: "https://www.dingfengkj.com/wx/kevin/check_token",//检测token是否依然有效
//	      header: {
//	        'token': 'afsdfasdfasdfasdf'//把从后台获取的token，放到header中
//	      },
//	      data: {
//	      
//	      },
//	      success: function (res) {
//	        console.log("后台返回的信息： " + res.data.code);
//	      }
//	    })
	

	private void setCopyProperties(WxMaUserInfo userInfo, WXUser user) {
		user.setOpenId(userInfo.getOpenId());
		user.setNickName(userInfo.getNickName());
		user.setGender(userInfo.getGender());
		user.setLanguage(userInfo.getLanguage());
		user.setCity(userInfo.getCity());
		user.setProvince(userInfo.getProvince());
		user.setCountry(userInfo.getCountry());
		user.setAvatarUrl(userInfo.getAvatarUrl());
		user.setUnionId(userInfo.getUnionId());
	} 
	
}
