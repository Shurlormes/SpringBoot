package com.voidforce.spring.boot.service.UserInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.mapper.UserInfoMapper;
import com.voidforce.spring.boot.service.UserInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public void insert(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
	}

	@Override
	@Cacheable(value = "UserInfoList", keyGenerator = "simpleKeyGenerator")
	public List<UserInfo> findAll() {
		return userInfoMapper.findAll();
	}

	@Override
	public PageInfo<UserInfo> findAllForPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserInfo> userInfoList = this.findAll();
		return new PageInfo<>(userInfoList);
	}
}

