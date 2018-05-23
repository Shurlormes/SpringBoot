package com.voidforce.spring.boot.mapper;

import com.voidforce.spring.boot.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper {

	@Select("SELECT * FROM USER_INFO")
	@Results({
		@Result(property = "userInfoId", column = "USER_INFO_ID"),
		@Result(property = "name", column = "NAME"),
		@Result(property = "email", column = "EMAIL"),
		@Result(property = "telephone", column = "TELEPHONE"),
		@Result(property = "address", column = "ADDRESS"),
		@Result(property = "age", column = "AGE")
	})
	List<UserInfo> findAll();

	@Insert(" INSERT INTO USER_INFO(NAME, EMAIL, TELEPHONE, ADDRESS, AGE) " +
		" VALUES(#{name}, #{email}, #{telephone}, #{address}, #{age})")
	void insert(UserInfo userInfo);
}
