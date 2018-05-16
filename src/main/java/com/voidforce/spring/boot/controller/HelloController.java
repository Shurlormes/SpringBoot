package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.service.common.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

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


		List<UserInfo> userInfoList = new ArrayList<>();
		UserInfo user1 = new UserInfo();
		UserInfo user2 = new UserInfo();
		UserInfo user3 = new UserInfo();
		UserInfo user4 = new UserInfo();

		user1.setName("张三");
		user1.setEmail("zhangsan@voidforce.com");
		user1.setTelephone("13912345678");
		user1.setAddress("北京");
		user1.setAge(25);

		user2.setName("李四");
		user2.setEmail("lisi@voidforce.com");
		user2.setTelephone("13587654321");
		user2.setAddress("深圳");
		user2.setAge(22);

		user3.setName("王二");
		user3.setEmail("wanger@voidforce.com");
		user3.setTelephone("13854321678");
		user3.setAddress("上海");
		user3.setAge(28);

		user4.setName("赵一");
		user4.setEmail("zhaoyi@voidforce.com");
		user4.setTelephone("13801234567");
		user4.setAddress("杭州");
		user4.setAge(24);

		userInfoList.add(user1);
		userInfoList.add(user2);
		userInfoList.add(user3);
		userInfoList.add(user4);

		model.addAttribute("userInfoList", userInfoList);
		return "hello";
	}
}
