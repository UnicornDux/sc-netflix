package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp09.config.FeignConfig;
import com.tedu.sp09.service.FBImpl.ItemFeignServiceFB;


/**
 * 要在接口和方法上，设置调用的后台服务，以及调用的后台服务路径
 * 
 * @author L Joson
 *
 * 指定访问哪个后台服务，可以获得服务的主机地址
 * @FeignClient(name = "item-server")
 * http://localhost:8001
 * 
 * @GetMapping("/{orderId}")
 * Feign利用SpringMVC注解,来确定访问路径
 * http://localhost:8001/{orderId}
 * 
 * @PathVariable("orderId")
 * 利用占位符，将路径中的占位符替换成具体参数
 * http://localhost:8001/1563423
 */
@FeignClient(
		name = "item-service",               // 服务名称
		fallback = ItemFeignServiceFB.class, // 熔断策略 
		configuration = FeignConfig.class    // 客户端调用配置（日志等信息）
)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable("orderId")String orderId); 
	
	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
	
}
