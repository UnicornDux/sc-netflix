package com.tedu.sp09.config;

import java.nio.channels.NonReadableChannelException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tedu.sp09.interceptor.CustomFeignInterceptor;

import feign.Contract;
import feign.Logger;
import feign.Request;



/**
 * 基于openFeign配置一些定制化的日志信息
 * @author Unicorn
 * --------------------------------------------
 * 1、全局配置, 当使用 @Configuration 会作用与所有的服务调用时的日志配置
 * 2、局部配置, 如果只想争对某一个服务惊醒配置，就不要使用 @Configuration
 *    指定对应的服务来进行配置，这样针对单个服务配置生效		
 * 		> 在配置@FeignClient 时配置configuration = FeignConfig.class 
 * 		> 在配置文件中直接配置 FeignClient 的级别
 */

@Configuration
public class FeignConfig {

	@Bean 
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	
/*	
	// 配置是否使用默认的契约
	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}
	
	// 配置超时时间
	@Bean
	public Request.Options options(){
		return new Request.Options(5000,10000);
	}
	
	// 配置自定义拦截器
	@Bean
	public CustomFeignInterceptor customFeignInterceptor() {
		return new CustomFeignInterceptor();
	}
*/
}
