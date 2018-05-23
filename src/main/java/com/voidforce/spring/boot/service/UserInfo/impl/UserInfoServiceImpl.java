package com.voidforce.spring.boot.service.UserInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.service.UserInfo.UserInfoService;
import com.voidforce.spring.boot.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

