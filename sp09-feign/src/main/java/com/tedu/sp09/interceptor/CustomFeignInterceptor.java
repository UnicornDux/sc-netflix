package com.tedu.sp09.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 自定义 Feign 拦截器
 * @author Unicorn
 */
public class CustomFeignInterceptor implements RequestInterceptor {	

	public static final Logger log 
		= LoggerFactory.getLogger(CustomFeignInterceptor.class);
	
	@Override
	public void apply(RequestTemplate template) {
		// TODO Auto-generated method stub
		// 拦截之后记录一下调用日志，
		// 拦截之后添加请求头等信息，（基于认证请求的时候, 微服务之间相互调用的时候需要在请求头中添加认证信息）

		template.header("hello","world");
		template.query("id", "hello_world");
		template.uri("/3");
		
		log.info("this is test interceptor");		
		
	}

}
