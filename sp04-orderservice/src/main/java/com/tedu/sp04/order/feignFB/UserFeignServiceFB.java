package com.tedu.sp04.order.feignFB;

import org.springframework.stereotype.Component;

import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.User;
import com.tedu.sp04.order.feign.UserFeignService;

@Component
public class UserFeignServiceFB implements UserFeignService {

	@Override
	public JsonResult<User> getUser(Integer userId) {
		if(Math.random()<0.4) {
			return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
		}
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult<String> addScore(Integer userId, Integer score) {
		return JsonResult.err("无法增加用户积分");
	}

}
