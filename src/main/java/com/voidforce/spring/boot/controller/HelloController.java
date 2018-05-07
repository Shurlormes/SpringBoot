package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.service.common.BaseMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Autowired
	private BaseMessageSource baseMessageSource;

	@GetMapping("/say/{str}")
	@ResponseBody
	public String say(@PathVariable String str) {
		return "Hello Spring Boot! " + str;
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", baseMessageSource.getMessage("home.message.welcome"));
		return "hello";
	}
}
