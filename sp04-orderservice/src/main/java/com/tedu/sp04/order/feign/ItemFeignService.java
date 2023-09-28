package com.tedu.sp04.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp04.order.feignFB.ItemFeignServiceFB;


@FeignClient(name = "item-service" ,fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable("orderId")String orderId);
	
	@PostMapping("/decreaseNumber")
	public JsonResult<?> decreaseNumber(@RequestBody List<Item> items) ;
}
