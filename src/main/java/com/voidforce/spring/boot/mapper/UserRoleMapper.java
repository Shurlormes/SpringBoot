package com.voidforce.spring.boot.mapper;

import com.voidforce.spring.boot.bean.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserRoleMapper {

	@Insert("INSERT INTO USER_ROLE(USER_INFO_ID, ROLE) VALUES(#{userInfoId}, #{role})")
	@Options(useGeneratedKeys = true, keyProperty = "userRoleId")
	void insert(UserRole userRole);

	@Select("SELECT * FROM USER_ROLE WHERE USER_INFO_ID = #{userInfoId} ")
	@Results(
		id = "simpleMapper",
		value = {
			@Result(property = "userRoleId", column = "USER_ROLE_ID"),
			@Result(property = "userInfoId", column = "USER_INFO_ID"),
			@Result(property = "role", column = "ROLE")
		}
	)
	List<UserRole> findByUserInfoId(Long userInfoId);

}
