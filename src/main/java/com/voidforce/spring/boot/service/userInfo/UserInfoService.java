package com.voidforce.spring.boot.service.userInfo;

import com.github.pagehelper.PageInfo;
import com.voidforce.spring.boot.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

	void insert(UserInfo userInfo);

	UserInfo getByEmail(String email);

	List<UserInfo> findAll();

	List<UserInfo> findAllAnother(UserInfo userInfo);

	PageInfo<UserInfo> findAllForPage(Integer pageNum, Integer pageSize);
}
