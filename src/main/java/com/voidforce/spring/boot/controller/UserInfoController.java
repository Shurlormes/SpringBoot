package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.service.UserInfo.UserInfoService;
import com.voidforce.spring.boot.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("")
	public String findAll(@RequestParam(required = false, defaultValue = "1") Integer page,
	                      @RequestParam(required = false, defaultValue = "1") Integer limit) {
		return JsonUtil.convertObject2Json(userInfoService.findAllForPage(page, limit));
	}

	@PostMapping("")
	public String addUserInfo(@ModelAttribute UserInfo userInfo) {
		userInfoService.insert(userInfo);
		return "success";
	}

}
