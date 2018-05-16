package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.service.common.SimpleMessageSource;
import com.voidforce.spring.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private SimpleMessageSource simpleMessageSource;

	@GetMapping("/say/{str}")
	@ResponseBody
	public String say(@PathVariable String str) {
		return "Hello Spring Boot! " + str;
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", simpleMessageSource.getMessage("home.message.welcome", new String[]{"From Controller"}));
		model.addAttribute("date", new Date());
		model.addAttribute("userId", "00001111");
		model.addAttribute("content", "你好世界");


		List<UserInfo> userInfoList = userInfoMapper.getAll();

		model.addAttribute("userInfoList", userInfoList);
		return "hello";
	}
}
