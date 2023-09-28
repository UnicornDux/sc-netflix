package com.tedu.sp09.service.FBImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp09.service.ItemFeignService;



@Component
public class ItemFeignServiceFB implements ItemFeignService{

	@Override
	public JsonResult<List<Item>> getItems(String orderId) {
		return JsonResult.err("无法获取订单商品列表");
	}

	@Override
	public JsonResult decreaseNumber(List<Item> items) {
		return JsonResult.err("无法修改商品库存");
	}


	
}
