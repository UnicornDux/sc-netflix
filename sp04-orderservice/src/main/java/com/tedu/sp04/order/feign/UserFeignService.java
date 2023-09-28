package com.tedu.sp04.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.User;
import com.tedu.sp04.order.feignFB.UserFeignServiceFB;


@FeignClient(name = "user-service",fallback = UserFeignServiceFB.class)
public interface UserFeignService {

	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable("userId")Integer userId);
	
	@GetMapping("/{userId}/score")
	public JsonResult<?> addScore(
		@PathVariable("userId")Integer UsserId, 
		@RequestParam Integer score);
	
}
