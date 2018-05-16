package com.voidforce.spring.mapper;

import com.voidforce.spring.boot.bean.UserInfo;

import java.util.List;

public interface UserInfoMapper {

	/*@Select("SELECT * FROM USER_INFO")
	@Results({
	})*/
	List<UserInfo> getAll();
}
