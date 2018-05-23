package com.voidforce.spring.boot.service.UserInfo;

import com.github.pagehelper.PageInfo;
import com.voidforce.spring.boot.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

	void insert(UserInfo userInfo);

	List<UserInfo> findAll();

	PageInfo<UserInfo> findAllForPage(Integer pageNum, Integer pageSize);
}
