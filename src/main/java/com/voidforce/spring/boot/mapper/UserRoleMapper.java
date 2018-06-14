package com.voidforce.spring.boot.mapper;

import com.voidforce.spring.boot.bean.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {

	@Insert("INSERT INTO USER_ROLE(USER_INFO_ID, ROLE) VALUES(#{userInfoId}, #{role})")
	void insert(UserRole userRole);

	@Select("SELECT * FROM USER_ROLE WHERE USER_INFO_ID = #{userInfoId} ")
	List<UserRole> findByUserInfoId(Long userInfoId);

}
