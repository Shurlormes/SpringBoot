package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.common.bean.HashMapResult;
import com.voidforce.spring.boot.service.userInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("")
	public HashMapResult findAll() {
		List<UserInfo> userInfoList = userInfoService.findAllAnother(new UserInfo());
		if(!CollectionUtils.isEmpty(userInfoList)) {
			return HashMapResult.failure("失败测试");
		}
		return HashMapResult.success(null, userInfoService.findAll());
	}

	@PostMapping("")
	public HashMapResult addUserInfo(@ModelAttribute UserInfo userInfo) {
		userInfoService.insert(userInfo);
		return HashMapResult.success();
	}

	@PostMapping("/add")
	public HashMapResult addTestUserInfo(@RequestBody @Validated UserInfo userInfo) {
		return HashMapResult.success("添加成功", userInfo);
	}

	@PutMapping("/put")
	public HashMapResult putTestUserInfo(@RequestBody Map<String, String> userInfo) {
		return HashMapResult.success("更新成功", userInfo);
	}

	@DeleteMapping("/delete/{id}")
	public HashMapResult deleteTestUserInfo(@PathVariable Long id) {
		return HashMapResult.success("删除成功", id);
	}
}
