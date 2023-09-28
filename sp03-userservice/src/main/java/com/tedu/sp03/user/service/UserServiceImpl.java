package com.tedu.sp03.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.edu.sp01.service.UserService;
import com.edu.web.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tedu.sp01.pojo.User;


import lombok.extern.slf4j.Slf4j;
@RefreshScope
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Value("${sp.user-service.users}")
	private String userJson;

	@Override
	public User getUser(Integer id) {

		log.info("用户json数据"+ userJson);
		List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>(){});
		
		for (User user : list) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return new User(id,"用户名"+id,"pwd"+id);
	}

	@Override
	public void addScore(Integer id, Integer score) {

		log.info("user "+id+" - 增加积分 "+score);
	}
}
