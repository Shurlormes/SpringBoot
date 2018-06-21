package com.voidforce.spring.boot.mapper;

import com.voidforce.spring.boot.bean.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoMapper {

	@Select("SELECT * FROM USER_INFO")
	@Results(
		id = "simpleMapper",
		value = {
			@Result(property = "userInfoId", column = "USER_INFO_ID"),
			@Result(property = "name", column = "NAME"),
			@Result(property = "email", column = "EMAIL"),
			@Result(property = "password", column = "PASSWORD"),
			@Result(property = "telephone", column = "TELEPHONE"),
			@Result(property = "address", column = "ADDRESS"),
			@Result(property = "age", column = "AGE")
		}
	)
	List<UserInfo> findAll();

	@Insert("INSERT INTO USER_INFO(NAME, EMAIL, PASSWORD, TELEPHONE, ADDRESS, AGE) " +
		" VALUES(#{name}, #{email}, #{password}, #{telephone}, #{address}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "userInfoId")
	void insert(UserInfo userInfo);

	@Select("SELECT * FROM USER_INFO WHERE EMAIL = #{email}")
	@ResultMap("simpleMapper")
	UserInfo getByEmail(String email);
}
