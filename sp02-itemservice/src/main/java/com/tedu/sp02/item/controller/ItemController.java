package com.tedu.sp02.item.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sp01.service.ItemService;
import com.edu.web.util.JsonResult;
import com.tedu.sp01.pojo.Item;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
		log.info("server.port="+port+", orderId="+orderId);
		
		if (Math.random()<0.6) {
			long t = new Random().nextInt(5000);
			log.info("item-service-"+port+"延迟"+t);
			try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		List<Item> items = itemService.getItems(orderId);
		return JsonResult.ok(items).msg("port="+port);
	}
	
	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(
			/* requestBody  */
			@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}
}

